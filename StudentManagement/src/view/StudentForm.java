package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentForm extends JFrame {


    // Labels
    public JLabel lblTitle, lblName, lblEmail, lblCourse;


    // Text Fields
    public JTextField txtName, txtEmail, txtCourse;


    // Buttons
    public JButton btnSave, btnView, btnUpdate, btnDelete;
    public JButton btnCalculator, btnLogout;


    // Table
    public JTable tblStudent;
    public JScrollPane scrollPane;



    public StudentForm() {

        initComponents();

    }



    private void initComponents() {


        setTitle("Student Management System");

        setSize(750,550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);




        // Title

        lblTitle = new JLabel(
                "STUDENT MANAGEMENT SYSTEM"
        );


        lblTitle.setFont(
                new Font("Arial",
                Font.BOLD,
                20)
        );


        lblTitle.setBounds(
                180,
                20,
                350,
                30
        );


        add(lblTitle);





        // Calculator Button

        btnCalculator = new JButton("Calculator");

        btnCalculator.setBounds(
                520,
                20,
                100,
                30
        );

        add(btnCalculator);





        // Logout Button

        btnLogout = new JButton("Logout");

        btnLogout.setBounds(
                630,
                20,
                80,
                30
        );

        add(btnLogout);







        // Name

        lblName = new JLabel("Name");

        lblName.setBounds(
                180,
                80,
                80,
                25
        );

        add(lblName);




        txtName = new JTextField();

        txtName.setBounds(
                270,
                80,
                200,
                25
        );

        add(txtName);







        // Email

        lblEmail = new JLabel("Email");

        lblEmail.setBounds(
                180,
                120,
                80,
                25
        );

        add(lblEmail);




        txtEmail = new JTextField();

        txtEmail.setBounds(
                270,
                120,
                200,
                25
        );

        add(txtEmail);







        // Course

        lblCourse = new JLabel("Course");

        lblCourse.setBounds(
                180,
                160,
                80,
                25
        );

        add(lblCourse);




        txtCourse = new JTextField();

        txtCourse.setBounds(
                270,
                160,
                200,
                25
        );

        add(txtCourse);







        // Save Button

        btnSave = new JButton("Save");

        btnSave.setBounds(
                140,
                210,
                90,
                30
        );

        add(btnSave);





        // View Button

        btnView = new JButton("View");

        btnView.setBounds(
                245,
                210,
                90,
                30
        );

        add(btnView);






        // Update Button

        btnUpdate = new JButton("Update");

        btnUpdate.setBounds(
                350,
                210,
                90,
                30
        );

        add(btnUpdate);






        // Delete Button

        btnDelete = new JButton("Delete");

        btnDelete.setBounds(
                455,
                210,
                90,
                30
        );

        add(btnDelete);








        // Table

        tblStudent = new JTable();


        tblStudent.setModel(
                new DefaultTableModel(

                        new Object[][] {},

                        new String[]{
                                "ID",
                                "Name",
                                "Email",
                                "Course"
                        }

                )
        );



        scrollPane =
                new JScrollPane(tblStudent);



        scrollPane.setBounds(
                30,
                270,
                680,
                180
        );


        add(scrollPane);







        // Calculator Button Action

        btnCalculator.addActionListener(
                new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                Calculator calculator =
                        new Calculator();


                calculator.setVisible(true);


            }


        });







        // Logout Button Action

        btnLogout.addActionListener(
                new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                int option =
                        JOptionPane.showConfirmDialog(
                                null,
                                "Do you want to logout?",
                                "Logout",
                                JOptionPane.YES_NO_OPTION
                        );



                if(option ==
                        JOptionPane.YES_OPTION){



                    new WelcomeForm()
                            .setVisible(true);



                    dispose();



                }


            }


        });



    }







    public static void main(String[] args) {


        SwingUtilities.invokeLater(
                new Runnable() {


            @Override
            public void run() {


                new StudentForm()
                        .setVisible(true);


            }


        });


    }


}