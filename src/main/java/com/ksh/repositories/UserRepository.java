package com.ksh.repositories;

import com.ksh.entities.User;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.context.annotation.Value;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.bson.conversions.Bson;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class UserRepository {

    @Inject
    private MongoClient mongoClient;
    @Value("${mongodb.database}")
    private String database;
    @Value("${mongodb.collection}")
    private String users;
    @Inject
    private MongoCollection<User> usersCollection;

    public User findById(int id) {
        Bson filter = eq("id", id);
        return Single.fromPublisher(mongoClient.getDatabase(database).getCollection(users, User.class).find(filter)).blockingGet();
    }

    public User save(User user) {
        return Single.fromPublisher(usersCollection.insertOne(user)).map(success -> user).blockingGet();
    }

    public User update(User user) {
        return Single.fromPublisher(usersCollection.insertOne(user)).map(success -> user).blockingGet();
    }

    public Iterable<User> findAll() {
        return Flowable.fromPublisher(mongoClient.getDatabase(database).getCollection(users, User.class).find()).blockingIterable();
    }

    public Iterable<User> findByName(String name) {
        Bson filter = eq("name", name);
        return Flowable.fromPublisher(usersCollection.find(filter)).blockingIterable();
    }
}
