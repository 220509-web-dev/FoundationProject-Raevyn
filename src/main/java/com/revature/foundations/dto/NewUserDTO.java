package com.revature.foundations.dto;

import com.revature.foundations.models.appUser;

public class NewUserDTO {
    private String username;
    private String password;
    private int id;
    private String first;
    private String last;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public appUser extractResource() {
        return new appUser(id, username, password, first, last, email);
    }

    @Override
    public String toString() {
        return "NewUserResponse{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", username=" + username +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

