package com.example.library.service;

import com.example.library.model.User;

public interface IUserService extends CrudService<User,Long>{

    User createUser(String name, String surname, String email);
}
