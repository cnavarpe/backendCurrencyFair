package com.currencyfair.services;

import com.currencyfair.database.model.User;

public interface UserService {

    User findById(Integer id);

    User save(User entity);

}
