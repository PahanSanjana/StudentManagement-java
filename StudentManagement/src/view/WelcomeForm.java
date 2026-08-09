package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeForm extends JFrame {

    private JLabel lblTitle;
    private JLabel lblSubtitle;
    private JButton btnLogin;
    private JButton btnSignup;
    private JButton btnExit;

    public WelcomeForm() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Student Management System");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        panel.setLayout(null);

        lblTitle = new JLabel("STUDENT MANAGEMENT SYSTEM");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(0, 51, 153));
        lblTitle.setBounds(80, 40, 550, 40);
        panel.add(lblTitle);

        lblSubtitle = new JLabel("Welcome");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblSubtitle.setBounds(290, 95, 150, 30);
        panel.add(lblSubtitle);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnLogin.setBounds(250, 170, 180, 45);
        panel.add(btnLogin);

        btnSignup = new JButton("Sign Up");
        btnSignup.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSignup.setBounds(250, 235, 180, 45);
        panel.add(btnSignup);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnExit.setBounds(250, 300, 180, 45);
        panel.add(btnExit);

        add(panel);

        // Login Button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm().setVisible(true);
                dispose();
            }
        });

        // Signup Button
        btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupForm().setVisible(true);
                dispose();
            }
        });

        // Exit Button
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WelcomeForm().setVisible(true);
            }
        });
    }
}