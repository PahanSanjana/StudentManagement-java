/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.UserDAO;
import model.User;

/**
 *
 * @author hnd
 */
public class UserController {
    

    UserDAO userDAO;
    public UserController() {
        userDAO = new UserDAO();
    }
    // User Registration Validation
    public boolean registerUser(String fullname,
                                String username,
                                String email,
                                String password) {

        // name 
        if(fullname == null || fullname.trim().isEmpty()) {
            return false;
        }
        if(fullname.length() < 3) {
            return false;
        }
        
        // Username 
        if(username == null || username.trim().isEmpty()) {
            return false;
        }
        if(username.length() < 4) {
            return false;
        }

        // Email 
        if(email == null || email.trim().isEmpty()) {
            return false;
        }
        if(!email.contains("@") || !email.contains(".")) {
            return false;
        }
        
        // Password 
        if(password == null || password.isEmpty()) {
            return false;
        }

        if(password.length() < 5) {
            return false;
        }

        //User 
        User user = new User();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);


        // Send data to DAO
        return userDAO.register(user);

    }

    // Login 
    public boolean loginUser(String username,
                             String password) {   
        if(username == null || username.trim().isEmpty()) {
            return false;
        }
        if(password == null || password.trim().isEmpty()) {
            return false;
        }

        return userDAO.login(username, password);
    }
}