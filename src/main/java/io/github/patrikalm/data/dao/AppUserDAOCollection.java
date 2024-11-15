package io.github.patrikalm.data.dao;


import io.github.patrikalm.model.AppUser;

import java.util.Collection;

public class AppUserDAOCollection implements AppUserDAO {


    @Override
    public AppUser persist(AppUser appUser) {
        return null;
    }

    @Override
    public AppUser findByUserName(String username) {
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return null;
    }

    @Override
    public void remove(String username) {

    }
}
