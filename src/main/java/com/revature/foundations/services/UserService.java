package com.revature.foundations.services;

import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.dto.ResourceCreationResponse;
import com.revature.foundations.models.AppUser;
import com.revature.foundations.Util.exceptions.InvalidRequestException;


public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ResourceCreationResponse createNewUser(AppUser newUser) {
        if (newUser == null ||
        newUser.getUsername() == null || newUser.getUsername().equals("") ||
        newUser.getPassword() == null || newUser.getPassword().equals(""))
        {
            String msg = "Provided user data was invalid. Username and Password must not be null.";
            throw new InvalidRequestException(msg);
        }

        return new ResourceCreationResponse(userDAO.save(newUser).getId());

    }

    public AppUser getUserByUsername(String username) {
        return null;
    }
}
