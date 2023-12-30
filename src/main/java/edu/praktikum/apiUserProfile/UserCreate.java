package edu.praktikum.apiUserProfile;

public class UserCreate {
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    private String name;
    public UserCreate withEmail(String email) {
        this.email = email;
        return this;
    }
    public UserCreate withPassword(String password) {
        this.password = password;
        return this;
    }
    public UserCreate withName(String name) {
        this.name = name;
        return this;
    }
}
