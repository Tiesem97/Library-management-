import java.sql.*;

//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
public class Javaconnect {

    Connection connection = Javaconnect.ConnectDb(); //establishes a connection to a MySQL database
    Statement statement;
    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //loads the MySQL Connector/J drive
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ library", "root", "password"); //establishes a connection to the MySQL database
            return con; //return if connection is successfull
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    public void exUpdate (String sql){ //method is used to execute a SQL statement that modifies the database, such as an INSERT, UPDATE, or DELETE statement.

        try {
            statement = connection.createStatement();// connection to Database
            statement.executeUpdate(sql); //executes a SQL statement
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void viewBook(String sql){


        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);//  method is used to execute a SQL statement that retrieves data from the database. ResultSet contains the data retrieved by the query.
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) { //next() method is used to move the cursor to the next row in the result set



                //Print one row
                for(int i = 1 ; i <= columnsNumber; i++){
                    System.out.print(rs.getString(i) + " "); //Print one element of a row
                }
                System.out.println();//Move to the next line to print the next row.
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
