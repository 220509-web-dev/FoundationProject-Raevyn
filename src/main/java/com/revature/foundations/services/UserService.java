package com.revature.foundations.services;

import com.revature.foundations.Util.Validator;
import com.revature.foundations.Util.exceptions.UsernameNotAvailable;
import com.revature.foundations.dto.NewUserDTO;
import com.revature.foundations.dto.NewUserResponse;
import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.dto.ResourceCreationResponse;
import com.revature.foundations.models.appUser;
import com.revature.foundations.Util.exceptions.InvalidRequestException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;




public class UserService {

    private UserDAO userDAO = new UserDAO();

    public UserService() {
        this.userDAO = userDAO;
    }

    public List<NewUserResponse> getUsersByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException("Invalid username provided");
        }

        List<appUser> userList = userDAO.getUsersByUsername(username);
        {

            if (userList.isEmpty()) {
                throw new UsernameNotAvailable("No users found");
            }

            return userList.stream()
                    .map(NewUserResponse::new)
                    .collect(Collectors.toList());
        }
    }

    public ResourceCreationResponse createNewUser(NewUserDTO newUserDTO) {
        try {
            Validator.UserValidator.isUserValid(newUserDTO);
            appUser newUser;
            newUser = newUserDTO.extractResource();
            newUser.setId(Integer.parseInt(UUID.randomUUID().toString()));
            userDAO.persist(newUser);
            return new ResourceCreationResponse(newUser.getId());
        } catch (RuntimeException e) {
            throw new InvalidRequestException("Invalid new user data", e);
        }
    }

    public void insert(appUser userToBeRegistered) {
    }
}
