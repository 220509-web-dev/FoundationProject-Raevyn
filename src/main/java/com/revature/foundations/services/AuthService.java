package com.revature.foundations.services;

import com.revature.foundations.Util.exceptions.InvalidCredentials;
import com.revature.foundations.Util.exceptions.UsernameNotAvailable;
import com.revature.foundations.services.UserService;
import com.revature.foundations.servlets.UserServlet;
import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.models.AppUser;


public class AuthService {

    UserService userService = new UserService();

    public AppUser login(String username, String password) {

        AppUser user;

        user = userService.getUserByUsername(username);

        if (user != null && pasword.equals(user.getPassword())) {
            System.out.println("Logged In Successfully");
            return user;

        } else if (user != null && !password.equals(user.getPassword())) {
            throw new InvalidCredentials("Wrong Password Entered");

        } else {
            System.out.println("User Does Not Exist!");
            throw new InvalidCredentials("User Does Not Exist.")
        }

    }


    public void register(AppUser userToBeRegistered) {

        if (userService.getUserByUsername(userToBeRegistered.getUsername()) != null) {

            throw new UsernameNotAvailable("Username is already taken");

        }

        userService.insert(userToBeRegistered);
    }

}