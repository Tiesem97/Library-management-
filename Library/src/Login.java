import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Shifat Mohammed 001027898
//Library Management CW COMP - 1815

public class Login {
    private JPanel pnlMain;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JLabel UsernameLab;
    private JLabel PasswordLab;
    private JButton LoginBut;

    static JFrame frameLog = new JFrame("Login");

    Login() {

        frameLog.setSize(400,200);// sets the size of the frame
        frameLog.setLocationRelativeTo(null); //sets the location of the frame at the centre of the screen.
        frameLog.setContentPane(pnlMain);//sets the content pane of the frame to the specified panel
        frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close operation for the frame. the frame should be terminated when it is closed.
        frameLog.setVisible(true);


        pnlMain.setSize(400,200);


        LoginBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //the text from the text fields are converted to lower case, and stored in strings.

                String txtuserName = textFieldUsername.getText().toLowerCase();
                String txtPassword = textFieldPassword.getText().toLowerCase();


                //check if Strings are empty
                if (txtuserName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter username"); //display a message on screen if String is empty
                }
                else if(txtPassword.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter password");//display a message on screen if String is empty
                }
                //check for correct credentials
                else if (txtuserName.equals("admin") && txtPassword.equals("password")){
                    JOptionPane.showMessageDialog(null,"Loggin in");

                    frameLog.dispose();

                    AdminLog adminLog = new AdminLog();





                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");

                }
            }
        });
    }

}
