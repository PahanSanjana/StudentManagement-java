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


public class SignupForm extends JFrame {


    JLabel lblTitle;
    JLabel lblFullname;
    JLabel lblUsername;
    JLabel lblEmail;
    JLabel lblPassword;
    JLabel lblConfirm;


    JTextField txtFullname;
    JTextField txtUsername;
    JTextField txtEmail;


    JPasswordField txtPassword;
    JPasswordField txtConfirm;


    JButton btnRegister;
    JButton btnLogin;
    JButton btnExit;


    UserController userController;



    public SignupForm() {

        userController = new UserController();

        initComponents();

    }



    private void initComponents() {


        setTitle("Signup Form");
        setSize(550,520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);



        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(
                new Color(245,248,255)
        );



        lblTitle = new JLabel("CREATE ACCOUNT");

        lblTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 26)
        );

        lblTitle.setBounds(150,30,300,40);

        panel.add(lblTitle);




        lblFullname = new JLabel("Full Name");
        lblFullname.setBounds(60,100,120,25);
        panel.add(lblFullname);


        txtFullname = new JTextField();
        txtFullname.setBounds(200,100,230,30);
        panel.add(txtFullname);




        lblUsername = new JLabel("Username");
        lblUsername.setBounds(60,150,120,25);
        panel.add(lblUsername);


        txtUsername = new JTextField();
        txtUsername.setBounds(200,150,230,30);
        panel.add(txtUsername);




        lblEmail = new JLabel("Email");
        lblEmail.setBounds(60,200,120,25);
        panel.add(lblEmail);


        txtEmail = new JTextField();
        txtEmail.setBounds(200,200,230,30);
        panel.add(txtEmail);




        lblPassword = new JLabel("Password");
        lblPassword.setBounds(60,250,120,25);
        panel.add(lblPassword);


        txtPassword = new JPasswordField();
        txtPassword.setBounds(200,250,230,30);
        panel.add(txtPassword);




        lblConfirm = new JLabel("Confirm");
        lblConfirm.setBounds(60,300,120,25);
        panel.add(lblConfirm);


        txtConfirm = new JPasswordField();
        txtConfirm.setBounds(200,300,230,30);
        panel.add(txtConfirm);




        btnRegister = new JButton("Register");
        btnRegister.setBounds(200,360,230,35);
        panel.add(btnRegister);



        btnLogin = new JButton("Back Login");
        btnLogin.setBounds(200,410,110,35);
        panel.add(btnLogin);



        btnExit = new JButton("Exit");
        btnExit.setBounds(320,410,110,35);
        panel.add(btnExit);



        add(panel);





        // REGISTER BUTTON

        btnRegister.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){


                String fullname =
                        txtFullname.getText().trim();


                String username =
                        txtUsername.getText().trim();


                String email =
                        txtEmail.getText().trim();


                String password =
                        String.valueOf(
                        txtPassword.getPassword()
                        );


                String confirm =
                        String.valueOf(
                        txtConfirm.getPassword()
                        );




                // Empty check

                if(fullname.equals("") ||
                   username.equals("") ||
                   email.equals("") ||
                   password.equals("") ||
                   confirm.equals("")){


                    JOptionPane.showMessageDialog(
                            null,
                            "Please fill all fields"
                    );

                    return;

                }




                // Password match

                if(!password.equals(confirm)){


                    JOptionPane.showMessageDialog(
                            null,
                            "Passwords do not match"
                    );

                    return;

                }




                // Controller validation

                boolean result =
                        userController.registerUser(
                                fullname,
                                username,
                                email,
                                password
                        );



                if(result){


                    JOptionPane.showMessageDialog(
                            null,
                            "Registration Successful"
                    );


                    new LoginForm().setVisible(true);

                    dispose();


                }
                else{


                    JOptionPane.showMessageDialog(
                            null,
                            "Registration Failed!\n\n"
                            +"Check:\n"
                            +"• Name minimum 3 characters\n"
                            +"• Username minimum 4 characters\n"
                            +"• Valid email required\n"
                            +"• Password minimum 5 characters\n"
                            +"• Username may already exist"
                    );


                }


            }


        });





        // BACK LOGIN BUTTON

        btnLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){


                new LoginForm().setVisible(true);

                dispose();


            }


        });





        // EXIT BUTTON

        btnExit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){


                System.exit(0);


            }


        });


    }



    public static void main(String args[]){

        new SignupForm().setVisible(true);

    }


}