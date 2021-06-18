package com.ksh.controllers;

import com.ksh.entities.User;
import com.ksh.repositories.UserRepository;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/user")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Get("/findAll")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Get("/findById/{id}")
    public User findById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @Post("/save")
    public User save(@Body User user) {
        return userRepository.save(user);
    }

    @Post("/update")
    public User update(@Body User user) {
        return userRepository.update(user);
    }

}
