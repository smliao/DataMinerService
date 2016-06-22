package com.data.miner.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = UserProfile.COLLECTION_NAME)
@ToString
@Getter
@AllArgsConstructor
public class UserProfile {

    public static final String COLLECTION_NAME = "userProfile";

    @Id
    private String id;

    private String username;

    private int age;

    private List<String> subreddit;

    public static UserProfile userProfile(String username, int age, List<String> subreddit) {
        return new UserProfile(
                UUID.randomUUID().toString(), username, age, subreddit);
    }
}
