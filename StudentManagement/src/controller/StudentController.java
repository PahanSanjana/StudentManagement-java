package controller;

import dao.studentDAO;
import model.Student;
import view.StudentForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StudentController {


    private final StudentForm view;
    private final studentDAO dao;



    public StudentController(StudentForm view) {
        this.view = view;
        this.dao = new studentDAO();
        view.btnSave.addActionListener(new ActionListener() {

           @Override
            public void actionPerformed(ActionEvent e) {
                saveStudent();
            }
        });
      view.btnView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               loadStudents();
            }
        });

        view.btnUpdate.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();

            }

        });



        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               deleteStudent();

            }

        });


    }




// data validation
    private boolean validateStudentData(){


        String name = view.txtName.getText().trim();
        String email = view.txtEmail.getText().trim();
        String course = view.txtCourse.getText().trim();


        // Name validation
        if(name.isEmpty()){
           JOptionPane.showMessageDialog(view,
                    "Student name is required");
            return false;
        }

        if(name.length() < 3){
            JOptionPane.showMessageDialog(view,
                    "Name must contain at least 3 characters");
            return false;
        }

        // Email validation
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(view,
                    "Email is required");
            return false;

        }


        if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(view,
                    "Enter a valid email address");
            return false;

        }

        // Course validation
        if(course.isEmpty()){
           JOptionPane.showMessageDialog(view,
                    "Course is required");
            return false;

        }

        return true;


    }


//save student
    private void saveStudent(){
        if(!validateStudentData()){
            return;
        }




        Student student = new Student();

        student.setName(
                view.txtName.getText().trim()
        );
      student.setEmail(
                view.txtEmail.getText().trim()
        );
        student.setCourse(
                view.txtCourse.getText().trim()
        );


        boolean result = dao.addStudent(student);

        if(result){


            JOptionPane.showMessageDialog(view,
                    "Student Added Successfully");
            clearFields();

        }
        else{

            JOptionPane.showMessageDialog(view,
                    "Failed To Add Student");


        }


    }







// view student
    private void loadStudents(){
        ArrayList<Student> list =
                dao.getAllStudents();

        DefaultTableModel model =
                (DefaultTableModel)view.tblStudent.getModel();

        model.setRowCount(0);

        for(Student s : list){
           model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                   s.getEmail(),
                    s.getCourse()
            });


        }


    }






//update student
    private void updateStudent(){



       if(!validateStudentData()){


            return;


        }




        int row =
                view.tblStudent.getSelectedRow();




        if(row == -1){


            JOptionPane.showMessageDialog(view,
                    "Select student first");


            return;


        }




        int id =
                Integer.parseInt(
                view.tblStudent.getValueAt(row,0)
                .toString()
                );





        Student student = new Student();



        student.setId(id);


        student.setName(
                view.txtName.getText().trim()
        );


        student.setEmail(
                view.txtEmail.getText().trim()
        );


        student.setCourse(
                view.txtCourse.getText().trim()
        );






        boolean result =
                dao.updateStudent(student);





        if(result){


            JOptionPane.showMessageDialog(view,
                    "Student Updated Successfully");


            loadStudents();


        }
        else{


            JOptionPane.showMessageDialog(view,
                    "Update Failed");


        }


    }






//delete student
    private void deleteStudent(){



        int row =
                view.tblStudent.getSelectedRow();




        if(row == -1){


            JOptionPane.showMessageDialog(view,
                    "Select student first");


            return;


        }




        int id =
                Integer.parseInt(
                view.tblStudent.getValueAt(row,0)
                .toString()
                );




        boolean result =
                dao.deleteStudent(id);




        if(result){


            JOptionPane.showMessageDialog(view,
                    "Student Deleted Successfully");


            loadStudents();


        }
        else{


            JOptionPane.showMessageDialog(view,
                    "Delete Failed");


        }



    }






    private void clearFields(){


        view.txtName.setText("");

        view.txtEmail.setText("");

        view.txtCourse.setText("");


    }



}