package com.revature.foundations.services;

import com.revature.foundations.DAO.UserDaoPostgres;
import com.revature.foundations.dto.ResourceCreationResponse;
import com.revature.foundations.models.AppUser;
import com.revature.foundations.Util.exceptions.InvalidRequestException;


public class UserService {

    private final UserDaoPostgres userDaoPostgres;

    public UserService(UserDaoPostgres userDaoPostgres) {
        this.userDaoPostgres = userDaoPostgres;
    }

    public ResourceCreationResponse createNewUser(User newUser) {
        if (newUser == null ||
        newUser.getUsername() == null || newUser.getUsername().equals("") ||
        newUser.getPassword() == null || newUser.getPassword().equals(""))\
        {
            String msg = "Provided user data was invalid. Username and Password must not be null.";
            throw InvalidRequestException(msg);
        }

        return new ResourceCreationResponse(userDaoPostgres.save(newUser).getId());

    }
}
