package com.revature.foundations.Util;

import com.revature.foundations.dto.NewUserDTO;
import com.revature.foundations.models.appUser;
import com.revature.foundations.Util.exceptions.InvalidRequestException;

public class Validator {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().equals("");
    }

    public static class UserValidator {

        public static void isUserValid(appUser user) {

            if (user == null) {
                throw new RuntimeException("Provided task object was null");
            }

            if (isNullOrEmpty(user.getUsername())) {
                throw new RuntimeException("Provided task contained a null or empty title");
            }

            if (user.getUsername().length() > 50) {
                throw new RuntimeException("Provided task contained a title that exceeds 50 characters");
            }

            if (isNullOrEmpty(user.getPassword())) {
                throw new RuntimeException("Provided task contained a null or empty description");
            }


            if (isNullOrEmpty(user.getFirst())) {
                throw new RuntimeException("Provided task contained a null or empty creator id");
            }

            if (isNullOrEmpty(user.getLast())) {
                throw new RuntimeException("Provided task contained a null or empty assignee id");
            }

            if (isNullOrEmpty(user.getEmail())) {
                throw new RuntimeException("Provided task contained a null or empty label");
            }

        }

        public static void isUserValid(NewUserDTO newUserDTO) {

            if (newUserDTO == null) {
                throw new RuntimeException("Provided task object was null");
            }

            isUserValid(newUserDTO.extractResource());

        }

    }
}
