package io.github.patrikalm.model;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;



    public AppUser(String username, String password, AppRole role) {

        setUsername(username);
        setPassword(password);
        setRole(role);

    }


    public String getUsername() {

        return this.username;
    }

    private void setUsername(String username) {
        if (username== null || username.trim().isEmpty())
            throw new IllegalArgumentException("Username can not be null or empty.");

        this.username = username;
    }

    public String getPassword() {

        return this.password;
    }

    private void setPassword(String password) {

        if (password == null || password.trim().isEmpty())
            throw new IllegalArgumentException("Password can not be null or empty.");

        this.password = password;
    }

    public AppRole getRole() {

        return this.role;
    }

    private void setRole(AppRole role) {

        if (role == null)
            throw new IllegalArgumentException("Role can not be null");

       this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        AppUser localUser = (AppUser) obj;

        if (this.username.equals(localUser.username)) {

            return this.role == localUser.role;
        }

        return false;
    }


    @Override
    public int hashCode() {

        return username.hashCode() + role.hashCode();
    }

    @Override
    public String toString() {

        return "Username: "+ username + "/nRole: " + role;
    }


}
