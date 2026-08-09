package view;

import controller.UserController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.StudentController;


public class LoginForm extends JFrame {

    JLabel lblTitle;
    JLabel lblUsername;
    JLabel lblPassword;

    JTextField txtUsername;
    JPasswordField txtPassword;

    JButton btnLogin;
    JButton btnSignup;
    JButton btnExit;

    UserController userController;


    public LoginForm() {

        userController = new UserController();

        initComponents();

    }


    private void initComponents() {


        setTitle("Login Form");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(new Color(245, 248, 255));


        lblTitle = new JLabel("LOGIN");

        lblTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 28)
        );

        lblTitle.setBounds(210, 40, 150, 40);

        panel.add(lblTitle);



        lblUsername = new JLabel("Username");

        lblUsername.setBounds(60, 120, 100, 25);

        panel.add(lblUsername);



        txtUsername = new JTextField();

        txtUsername.setBounds(170, 120, 230, 30);

        panel.add(txtUsername);




        lblPassword = new JLabel("Password");

        lblPassword.setBounds(60, 170, 100, 25);

        panel.add(lblPassword);




        txtPassword = new JPasswordField();

        txtPassword.setBounds(170, 170, 230, 30);

        panel.add(txtPassword);




        btnLogin = new JButton("Login");

        btnLogin.setBounds(170, 230, 230, 35);

        panel.add(btnLogin);




        btnSignup = new JButton("Sign Up");

        btnSignup.setBounds(170, 280, 110, 35);

        panel.add(btnSignup);




        btnExit = new JButton("Exit");

        btnExit.setBounds(290, 280, 110, 35);

        panel.add(btnExit);



        add(panel);



        // LOGIN BUTTON

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                String username = txtUsername.getText();


                String password = String.valueOf(
                        txtPassword.getPassword()
                );



                boolean result =
                        userController.loginUser(
                                username,
                                password
                        );



                if(result) {


                    JOptionPane.showMessageDialog(
                            null,
                            "Login Successful"
                    );



                 StudentForm form = new StudentForm();

StudentController controller =
        new StudentController(form);

form.setVisible(true);

dispose();


                } else {


                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Username or Password"
                    );

                }


            }

        });





        // SIGNUP BUTTON

        btnSignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                SignupForm signup =
                        new SignupForm();


                signup.setVisible(true);


                dispose();


            }

        });






        // EXIT BUTTON

        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                System.exit(0);


            }

        });


    }



    public static void main(String args[]) {


        new LoginForm().setVisible(true);


    }


}