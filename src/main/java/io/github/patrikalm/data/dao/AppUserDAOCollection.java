package io.github.patrikalm.data.dao;


import io.github.patrikalm.model.AppUser;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class AppUserDAOCollection implements AppUserDAO {


    // DAO implemented in a singleton pattern using private static final Collection and thus not creating new instances
    private static final Collection<AppUser> appUsers = new HashSet<>();


    @Override
    public AppUser persist(AppUser appUser) {

        appUsers.add(appUser);

        return appUser;
    }

    @Override
    public AppUser findByUserName(String username) {

        if (username == null) throw new IllegalArgumentException("Username can not be empty or null");

        for (AppUser appUser : appUsers) {

            if (appUser.getUsername().equalsIgnoreCase(username)) {
                return appUser;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {

        return appUsers;
    }

    @Override
    public void remove(String username) {

        if (username == null) throw new IllegalArgumentException("Username can not be empty or null");

        for (AppUser appUser : appUsers) {

            if (appUser.getUsername().equalsIgnoreCase(username)) {

                appUsers.remove(appUser);
            }
        }
    }
}
