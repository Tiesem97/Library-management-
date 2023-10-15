import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
public class AddBookGui {

    JFrame frame = new JFrame("Add new Book!");
    private JPanel addBookPnl;
    private JLabel labelGui;
    private JButton saveBtn;
    private JTextField titleTxt;
    private JTextField firstNameTxt;
    private JTextField yearTxt;
    private JTextField publisherTxt;
    private JTextField subjectTxt;
    private JPanel authotPnl;
    private JLabel titleLbl;
    private JPanel bookDetailsPnl;
    private JPanel titlePnl;
    private JPanel publisherPnl;
    private JPanel yearPnl;
    private JPanel subjPnl;
    private JTextField lastNameTxt;
    private JLabel firstNameLbl;
    private JLabel lastNameLbl;

    String title;
    String authorFirstNm;
    String authorLastNm;
    int year;
    String publisher;
    String subject;
    String authorFullName;
    Connection connection = Javaconnect.ConnectDb();//establishes a connection to a MySQL database
    Statement statement;

    Books books =new Books();


    AddBookGui(){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//This line of code sets the default close operation for the frame. the frame should be disposed when it is closed.
        frame.setLocationRelativeTo(null);//sets the location of the frame at the centre of the screen.
        frame.setContentPane(addBookPnl);//sets the content pane of the frame to the specified panel
        frame.setSize(800,300); // sets the size of the frame
        //frame.pack();
        frame.setVisible(true);




        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {






                title = titleTxt.getText();//the text from the text field is stored in a string.
                authorFirstNm = firstNameTxt.getText();//the text from the text field is stored in a string.
                authorLastNm = lastNameTxt.getText();//the text from the text field is stored in a string.
                publisher = publisherTxt.getText();//the text from the text field is stored in a string.
                subject = subjectTxt.getText();//the text from the text field is stored in a string.


                //check if textfield is an Integer
                try {
                    if (!yearTxt.getText().isEmpty()){
                        year = Integer.parseInt(yearTxt.getText());
                    }
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Characters are not allowed. Please enter correct year!");
                }


                boolean saved = false;

                while(!saved){

                    if (title.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter title"); // checks if text field is empty
                    } else if (authorFirstNm.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter First Name");// checks if text field is empty
                    }

                    else if(authorLastNm.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter Last Name");// checks if text field is empty
                    }

                    else if(year >2023){
                        JOptionPane.showMessageDialog(null, "Please enter valid Year of pubblication");// checks if text field is empty
                    }

                    else if(publisher.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter publisher");// checks if text field is empty
                    }

                    else if(subject.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter subject");// checks if text field is empty
                    } else {





                        authorFullName= books.capitalFirst(authorFirstNm) + " " + books.capitalFirst(authorLastNm);

                        // saving data in DataBase using lambda expression
                        String sqlAuthor = "INSERT INTO `library`.`author` (`FirstName`, `LastName`) VALUES ('"+ books.capitalFirst(authorFirstNm)+ "', '" + books.capitalFirst(authorLastNm)+ "');" ;
                        String sqlPublisher = "INSERT INTO `library`.`publisher` (`Publisher`) VALUES ('" + publisher+ "');" ;
                        String sqlBook = "INSERT INTO `library`.`books` (`Title`, `Author`, `Year of Publication`, `Publisher`, `Subject`) VALUES ('" + books.capitalFirst(title) + "', '" + authorFullName + "', '" + year + "', '" + books.capitalFirst(publisher) + "', '" + books.capitalFirst(subject) + "');";



                        DataPersistance dataPersistance = (sql)-> { //creates a lambda expression that implements the interface's single abstract method
                            try {
                                statement = connection.createStatement();
                                statement.executeUpdate(sql); //executes a SQL statement passed as an argument to the lambda expression

                            }catch (Exception exception){
                                exception.printStackTrace();
                            }
                        };

                        //calls the saveToDB() method of the dataPersistance object and passes the String variable as an argument.
                        dataPersistance.saveToDB(sqlAuthor);
                        dataPersistance.saveToDB(sqlPublisher);
                        dataPersistance.saveToDB(sqlBook);



                        JOptionPane.showMessageDialog(null,"New book added succesfully!");

                        frame.dispose();

                    }

                    saved = true;
                }


            }
        });
    }
}
