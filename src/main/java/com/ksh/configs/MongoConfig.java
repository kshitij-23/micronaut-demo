package com.ksh.configs;

import com.ksh.entities.User;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;

import javax.inject.Inject;
import javax.inject.Singleton;

@Context
@Factory
public class MongoConfig {

    @Inject
    private MongoClient mongoClient;
    @Value("${mongodb.database}")
    private String database;
    @Value("${mongodb.collection}")
    private String users;

    @Singleton
    public MongoDatabase getMongoDatabase() {
        return mongoClient.getDatabase(database);
    }

    @Singleton
    public MongoCollection<User> getUserCollection() {
        return getMongoDatabase().getCollection(users, User.class);
    }

}
