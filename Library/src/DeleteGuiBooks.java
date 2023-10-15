import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
public class DeleteGuiBooks {
    private JButton deleteBookButton;
    private JTextField idTxt;
    private JPanel deletePnl;
    JFrame frame = new JFrame("Delete book!");

    int idBooks;


    DeleteGuiBooks(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//This line of code sets the default close operation for the frame. the frame should be disposed when it is closed.
        frame.setLocationRelativeTo(null);//sets the location of the frame at the centre of the screen.
        frame.setContentPane(deletePnl);//sets the content pane of the frame to the specified panel
        frame.setSize(200,200);// sets the size of the frame
        frame.pack();
        frame.setVisible(true);



        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //check if textfield is an Integer
                try {
                    if (!idTxt.getText().isEmpty()){
                        idBooks = Integer.parseInt(idTxt.getText());
                    }
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Characters are not allowed. Please enter correct Book ID!");
                }

                Books books = new Books(); // creates book object

                books.deleteBookFromDb(idBooks); // call method from Books class to delete a book from DataBase

                JOptionPane.showMessageDialog(null,"Book deleted succesfully!");
                frame.dispose();


            }
        });
    }


}
