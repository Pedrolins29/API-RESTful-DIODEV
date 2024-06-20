package com.desafio.dio.API.RESTful.service.impl;

import com.desafio.dio.API.RESTful.domain.model.User;
import com.desafio.dio.API.RESTful.domain.model.repository.UserRepository;
import com.desafio.dio.API.RESTful.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists. ");
        }
        return userRepository.save(userToCreate);
    }
}
