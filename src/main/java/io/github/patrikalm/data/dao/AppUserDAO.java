package io.github.patrikalm.data.dao;


import io.github.patrikalm.model.AppUser;

import java.util.Collection;


public interface AppUserDAO {


AppUser persist(AppUser appUser);
AppUser findByUserName(String username);

Collection<AppUser> findAll();

void remove(String username);


}
