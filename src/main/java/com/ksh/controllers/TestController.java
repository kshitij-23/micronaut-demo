package com.ksh.controllers;

import com.ksh.Constants;
import com.ksh.entities.Person;
import com.ksh.repositories.PersonRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
public class TestController {

    @Inject
    private PersonRepository personRepository;

    @Get("/test")
    public String test() {
        return "Hello Micronaut...";
    }

    @Get("/test1")
    public Flowable<String> test1() {
        List<String> strings = new ArrayList<>();
        strings.add("K1");
        strings.add("K2");
        strings.add("K3");
        strings.add("K4");
        strings.add("K5");
        return Flowable.fromIterable(strings);
    }

    @Get("/test2")
    public Flowable<Integer> test2() {
        return Flowable.fromCallable(() -> {
            int r = new Random().nextInt(100);
            return r;
        }).doOnNext(person -> System.out.println("Server: {}" +person))
                .repeat(100).delay(100, TimeUnit.MILLISECONDS);
    }

    @Get("/findAll")
    public Iterable<Person> findAll() {
        System.out.println(Constants.atomicInteger.addAndGet(1));
        return personRepository.findAll();
    }

    @Post("/save")
    public Person save(@Body Person person) {
        System.out.println(Constants.atomicInteger.addAndGet(1));
        if(person.getId() == 0) {
            person.setId(Long.valueOf(gen()));
        }
        return personRepository.save(person);
    }

    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return 20000 + r.nextInt(30000);
    }
}
