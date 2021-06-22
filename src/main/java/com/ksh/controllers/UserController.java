package com.ksh.controllers;

import com.ksh.entities.Address;
import com.ksh.entities.User;
import com.ksh.repositories.UserRepository;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/user")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Get("/test")
    public User test() {
        User user = new User();
        user.setUserId("0");
        user.setAddress(new Address("Line1", "Line2", "Gujarat", 387002));
        user.setEmail("ks@ks.com");
        user.setMobile("9033513017");
        user.setName("Kshitij");
        return user;
    }

    @Get("/findAll")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Get("/findById/{id}")
    public User findById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @Get("/findByIdString/{id}")
    public User findByIdString(@PathVariable String id) {
        return userRepository.findByString(id);
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
