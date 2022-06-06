package com.revature.foundations.DAO;

import

import java.util.List;

public interface UserDAO {

    User createUser (User user);

    User getUserById (int Id);

    USer getUserByUsername (String username);

    List<User> getAllUsers();

    User updateUser (User user);

    void deleteUserbyId(int Id);
}
