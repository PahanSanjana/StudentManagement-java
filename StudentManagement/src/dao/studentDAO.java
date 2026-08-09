package dao;

import db.DBconnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class studentDAO {


    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;



    // ADD STUDENT

    public boolean addStudent(Student student) {

        boolean status = false;


        try {


            con = DBconnection.getConnection();


            String sql = "INSERT INTO Student (Name, Email, Course) VALUES (?, ?, ?)";


            pst = con.prepareStatement(sql);


            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getCourse());


            int row = pst.executeUpdate();



            if(row > 0){

                status = true;

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return status;

    }





    // GET ALL STUDENTS


    public ArrayList<Student> getAllStudents(){


        ArrayList<Student> students = new ArrayList<>();


        try{


            con = DBconnection.getConnection();



            String sql = "SELECT * FROM Student";


            pst = con.prepareStatement(sql);


            rs = pst.executeQuery();



            while(rs.next()){


                Student student = new Student();



                student.setId(rs.getInt("ID"));

                student.setName(rs.getString("Name"));

                student.setEmail(rs.getString("Email"));

                student.setCourse(rs.getString("Course"));



                students.add(student);


            }



        }
        catch(Exception e){

            e.printStackTrace();

        }



        return students;


    }





    // UPDATE STUDENT


    public boolean updateStudent(Student student){


        boolean status = false;



        try{


            con = DBconnection.getConnection();



            String sql =
                    "UPDATE Student SET Name=?, Email=?, Course=? WHERE ID=?";



            pst = con.prepareStatement(sql);



            pst.setString(1, student.getName());

            pst.setString(2, student.getEmail());

            pst.setString(3, student.getCourse());

            pst.setInt(4, student.getId());



            int row = pst.executeUpdate();



            if(row > 0){

                status = true;

            }



        }
        catch(Exception e){

            e.printStackTrace();

        }



        return status;


    }







    // DELETE STUDENT


    public boolean deleteStudent(int id){


        boolean status = false;



        try{


            con = DBconnection.getConnection();



            String sql =
                    "DELETE FROM Student WHERE ID=?";



            pst = con.prepareStatement(sql);



            pst.setInt(1,id);



            int row = pst.executeUpdate();




            if(row > 0){

                status = true;

            }



        }
        catch(Exception e){

            e.printStackTrace();

        }



        return status;


    }



}