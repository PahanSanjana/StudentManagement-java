package studentmanagement;

import view.WelcomeForm;

public class StudentManagement {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WelcomeForm welcome =
                        new WelcomeForm();
               welcome.setVisible(true);

            }

        });

    }


}