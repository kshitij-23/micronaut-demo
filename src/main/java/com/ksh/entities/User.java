package com.ksh.entities;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
public class User {

    @BsonId
    @BsonProperty("_id")
    private ObjectId _id;
    @BsonProperty("id")
    private String userId;
    private String name;
    private String email;
    private String mobile;
    @BsonProperty("country")
    private String country;
    @BsonProperty("address")
    private Address address;

}
