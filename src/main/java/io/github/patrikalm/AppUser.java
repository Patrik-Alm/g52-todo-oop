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

        return "0";
    }

    private void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return "0";
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
        if
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
