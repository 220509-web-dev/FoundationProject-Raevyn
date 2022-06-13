package com.revature.foundations.services;


import com.revature.foundations.Util.exceptions.InvalidCredentials;
import com.revature.foundations.Util.exceptions.UsernameNotAvailable;
import com.revature.foundations.models.appUser;
import com.revature.foundations.services.UserService;
import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.Util.ContextLoaderListener;


public class AuthService {


    public void register(appUser userToBeRegistered) {
        if (userService.getUsersByUsername(userToBeRegistered.getUsername()) != null) {
            throw new UsernameNotAvailable("Username is already taken");
        }
        userService.insert(userToBeRegistered);
    }
    UserService userService = new UserService();

    public appUser login(String username, String password) {
        appUser user;

        user = (appUser) userService.getUsersByUsername(username);

        if (user!=null && password.equals(user.getPassword())) {

            System.out.println("Logged In Successfully!");
            return user;
        } else if (user!=null && !password.equals(user.getPassword())) {
            System.out.println("Wrong password");
            throw new InvalidCredentials("Wrong Password");
        } else {
            System.out.println("User Does Not Exist");
            throw new InvalidCredentials("User Does Not Exist.");
        }
    }

}
