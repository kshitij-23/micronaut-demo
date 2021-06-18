package com.ksh.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
public class User {

    @BsonId
    @BsonProperty("_id")
    private ObjectId _id;
    @BsonProperty("id")
    private int userId;
    private String name;
    private String email;
    private String mobile;

}
