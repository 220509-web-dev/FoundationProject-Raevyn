package com.revature.foundations.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class appUser {

    private int id;

    @JsonProperty("firstName")
    private String first;
    @JsonProperty("lastName")
    private String last;
    private String email;
    private String username;
    private String password;


    public appUser() {
        super();
    }

    public appUser(int id, String first, String last, String email, String username, String password) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String firstName) {
        this.first = firstName;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String lastName) {
        this.last = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        appUser appUser = (com.revature.foundations.models.appUser) o;
        return id == appUser.id && Objects.equals(first, appUser.first) && Objects.equals(last, appUser.last) && Objects.equals(email, appUser.email) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first, last, email, username, password);
    }

    @Override
    public String toString() {
        return "appUser{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}