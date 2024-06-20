package com.desafio.dio.API.RESTful.service;

import com.desafio.dio.API.RESTful.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
