import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
public class AdminLog {

    JFrame frame = new JFrame("Admin Login");
    String sql;
    Connection connection = Javaconnect.ConnectDb(); //establishes a connection to a MySQL database
    Statement statement;
    Books books = new Books();
    DefaultTableModel deftable = new DefaultTableModel();
    String[] columnNames = {"IdBooks","Author","Title","Year of publication", "Publisher", "Subject"}; // column names of Books list table
    String[] columnNamesAuthors = {"IdAuthors","First Name","Last Name"}; // column names for authors list table
    String[] columnNamesPublisher = {"IdPublisher","Name Publisher"}; // column names for publisher list table
    private JTable table;
    private JComboBox autOrTitleLbl;
    private JTextField txtSearch;
    private JButton searchButton;
    private JLabel searchByLbl;
    private JButton addButton;
    private JButton viewAllButton;
    private JButton deleteButton;
    private JPanel guiPanel;
    private JScrollPane scrollPane;
    private JButton viewAuthorButton;
    private JButton viewPublisherButton;
    private JRadioButton bubbleRadio;
    private JRadioButton mergeRadio;
    private JRadioButton idSort;
    private JPanel searchPnl;
    private JLabel timeStampLbl;
    ArrayList<Books> listBooks = new ArrayList<Books>();
    BubbleSort bubbleSort = new BubbleSort();

    MergeSort mergeSort = new MergeSort();




    AdminLog(){



        searchPnl.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close operation for the frame. the frame should be terminated when it is closed.
        frame.setLocationRelativeTo(null);//sets the location of the frame at the centre of the screen.
        frame.setSize(2000,1400);// sets the size of the frame
        frame.setContentPane(guiPanel);//sets the content pane of the frame to the specified panel
        frame.pack();
        frame.setVisible(true);




        guiPanel.setSize(2000,1400);






        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                sql = "SELECT * FROM library.books;"; //retrieve all rows from the books table in the library database
                deleteTable();// removes all rows from a table,  this method can be called to clear the table when the list is updated.


                // check for selected radio button for sorting algorithm
                if (bubbleRadio.isSelected()){

                    System.out.println("Bubble Sort Algorithm used");
                    showBooksInJtableBubble(sql); //list all Authors using bubble sort algorithm

                }else if(mergeRadio.isSelected()){

                    System.out.println("Merge sort Algorithm used");
                    showBooksInJtableMerge(sql); //list all Authors using merge sort algorithm
                } else {
                    showBooksInJtable(sql);//list all books without sorting algorithm
                }


                listBooks.clear(); //remove all elements from list.

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookGui addBookGui = new AddBookGui();
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteGuiBooks deleteGuiBooks = new DeleteGuiBooks();
            }
        });

        viewAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "SELECT * FROM library.author;";//retrieve all rows from the author table in the library database
                deleteTable();// removes all rows from a table,  this method can be called to clear the table when the list is updated.
                createTableAuthors();

                try {
                    statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);//  method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.

                    while (rs.next()){ //next() method is used to move the cursor to the next row in the result set

                        // retrieves values of the columns in DataBase and stores in variables
                        int idAuthor = rs.getInt(1);
                        String firstName = rs.getString(2);
                        String lastName = rs.getString(3);


                        deftable.addRow(new Object[]{idAuthor, firstName, lastName}); //retrieves the values of columns and adds rows to a table model
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        viewPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "SELECT * FROM library.publisher;";//retrieve all rows from the publisher table in the library database

                deleteTable();// removes all rows from a table,  this method can be called to clear the table when the list is updated.
                createTablePublisher();

                try {
                    statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);//  method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.

                    while (rs.next()){

                        // retrieves values of the columns in DataBase and stores in variables
                        int idPublisher = rs.getInt(1);
                        String namePublisher = rs.getString(2);



                        deftable.addRow(new Object[]{idPublisher, namePublisher}); //retrieves the values of columns and adds rows to a table model
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model); //is used to sort and filter rows in a JTable.
                table.setRowSorter(tr); //sets the row sorter of the table object to the tr object
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim())); //(?i)indicates that the search should be case-insensitive

            }
        });
    }

    public void createTable(){
        deftable.setColumnIdentifiers(columnNames); // sets the column names for table model
        table.setModel(deftable);
    }

    public void createTableAuthors(){
        deftable.setColumnIdentifiers(columnNamesAuthors);// sets the column names for table model
        table.setModel(deftable);
    }

    public void createTablePublisher(){
        deftable.setColumnIdentifiers(columnNamesPublisher);// sets the column names for table model
        table.setModel(deftable);
    }


    public void deleteTable(){
        deftable.setRowCount(0);// removes all rows from a table,  this method can be called to clear the table when the list is updated.
    }


    public ArrayList<Books> ListBooks (String query){

        try {
            statement = connection.createStatement(); // connection to Database
            ResultSet rs = statement.executeQuery(query); //method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.
            Books books;

            while (rs.next()){ //next() method is used to move the cursor to the next row in the result set

               //retrieve data from column in DataBase and create objects of Books class
                //calls constructor of Books class
                books = new Books(
                        rs.getInt("idBooks"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Year of Publication"),
                        rs.getString("Publisher"),
                        rs.getString("Subject")
                );
                listBooks.add(books); // add objects into ArraList<Books>listBooks
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        timeStampLbl.setText("Sorting Time");
        return listBooks;
    }

    //retrieve all data and perform and sort list of Authors using Bubble sort algorithm
    public ArrayList<Books> ListBooksBubble (String query){

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);//  method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.
            Books books;

            while (rs.next()){ //next() method is used to move the cursor to the next row in the result set

                //retrieve data from column in DataBase and create objects of Books class
                //calls constructor of Books class
                books = new Books(
                        rs.getInt("idBooks"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Year of Publication"),
                        rs.getString("Publisher"),
                        rs.getString("Subject")
                );
                listBooks.add(books); // add objects into ArraList<Books>listBooks
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        //measures the time it takes to sort a list of Authors using a bubble sort algorithm.
        long startTime = System.currentTimeMillis();
        System.out.println("Bubble sort Start time: " + startTime);

        bubbleSort.bubbleSort(listBooks); //calls BubbleSort class and function to sort list of books by author

        long endTime = System.currentTimeMillis();
        System.out.println("End Time: "+ endTime);

        long elapsedTime = endTime - startTime; // calculates the elapsed time by subtracting the start time from the end time

        System.out.println("Bubble sort Elapsed time: " + elapsedTime + " Milliseconds");

        timeStampLbl.setText("Bubble sort Elapsed time: " + elapsedTime + " Milliseconds");


        return listBooks;
    }

    //retrieve all data and perform and sort list of Authors using Merge sort algorithm
    public ArrayList<Books> ListBooksMerge (String query){

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);//  method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.
            Books books;

            while (rs.next()){ //next() method is used to move the cursor to the next row in the result set

                //retrieve data from column in DataBase and create objects of Books class
                //calls constructor of Books class
                books = new Books(
                        rs.getInt("idBooks"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("Year of Publication"),
                        rs.getString("Publisher"),
                        rs.getString("Subject")
                );
                listBooks.add(books); // add objects into ArraList<Books>listBooks
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //measures the time it takes to sort a list of Authors using a merge sort algorithm.
        long startTime = System.currentTimeMillis();
        System.out.println("Merge sort Start time: " + startTime);

        mergeSort.mergeSort(listBooks);//calls MergeSort class and function to sort list of books by author

        long endTime = System.currentTimeMillis();
        System.out.println("End Time: "+ endTime);

        long elapsedTime = endTime - startTime; // calculates the elapsed time by subtracting the start time from the end time

        System.out.println("Merge sort Elapsed time: " + elapsedTime + " Milliseconds");

        timeStampLbl.setText("Merge sort Elapsed time: " + elapsedTime + " Milliseconds");

        return listBooks;
    }




    //method used to display ArrayList<Books> in Jtable
    public void showBooksInJtable (String OrderQuery){

        ArrayList<Books> books = ListBooks(OrderQuery);
        createTable();

        Object[] row = new Object[6]; //array of objects

        for (int i = 0; i < books.size(); i++) { //loop will continue to execute as long as i is less than the size of the books list.

            //retrieve data from arraylist and assign to Object row
            row[0] = books.get(i).getIdBooks();
            row[1] = books.get(i).getAuthor();
            row[2] = books.get(i).getTitle();
            row[3] = books.get(i).getYearOfPub();
            row[4] = books.get(i).getPublisher();
            row[5] = books.get(i).getSubject();

            deftable.addRow(row); // add object row to table
        }
    }


    //method used to display sorted ArrayList<Books> in Jtable
    public void showBooksInJtableBubble (String OrderQuery){

        ArrayList<Books> books = ListBooksBubble(OrderQuery);
        createTable();

        Object[] row = new Object[6];//array of objects

        for (int i = 0; i < books.size(); i++) {

            //retrieve data from arraylist and assign to Object row
            row[0] = books.get(i).getIdBooks();
            row[1] = books.get(i).getAuthor();
            row[2] = books.get(i).getTitle();
            row[3] = books.get(i).getYearOfPub();
            row[4] = books.get(i).getPublisher();
            row[5] = books.get(i).getSubject();

            deftable.addRow(row); // add object row to table
        }
    }

    //method used to display sorted ArrayList<Books> in Jtable
    public void showBooksInJtableMerge (String OrderQuery){

        ArrayList<Books> books = ListBooksMerge(OrderQuery);
        createTable();

        Object[] row = new Object[6];//array of objects

        for (int i = 0; i < books.size(); i++) {

            //retrieve data from arraylist and assign to Object row
            row[0] = books.get(i).getIdBooks();
            row[1] = books.get(i).getAuthor();
            row[2] = books.get(i).getTitle();
            row[3] = books.get(i).getYearOfPub();
            row[4] = books.get(i).getPublisher();
            row[5] = books.get(i).getSubject();

            deftable.addRow(row); // add object row to table
        }
    }





}

