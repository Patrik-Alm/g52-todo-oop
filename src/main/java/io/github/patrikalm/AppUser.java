package io.github.patrikalm;

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

        this.username = username;
    }

    public String getPassword() {

        return this.password;
    }

    private void setPassword(String password) {

        this.password = password;
    }

    public AppRole getRole() {

        return this.role;
    }

    private void setRole(AppRole role) {

        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        AppUser localUser = (AppUser) obj;

        if (this.username == localUser.username) {

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
