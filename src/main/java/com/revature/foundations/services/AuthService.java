package com.revature.foundations.services;

import com.revature.foundations.Util.exceptions.InvalidCredentials;
import com.revature.foundations.Util.exceptions.UsernameNotAvailable;
import com.revature.foundations.services.UserService;


public class AuthService {

    UserService userService = new UserService();

    public User login (String username, String password) {

        User user;

        user = userService.getUserByUsername(username);

        if (user!=null && pasword.equals(user.getPassword())) {
            System.out.println("Logged In Successfully");
            return user;

        } else if (user!=null && !password.equals(user.getPassword())){
                throw new InvalidCredentials("Wrong Password Entered");

            } else {
        System.out.println("User Does Not Exist!");
        throw new InvalidCredentials("User Does Not Exist.")
            }

        }




    public void register( User userToBeRegistered);

    if (userService.getUserByUsername(userToBeRegistered.getUsername()) != null) {

        throw new UsernameNotAvailable("Username is already taken")
    }
}
