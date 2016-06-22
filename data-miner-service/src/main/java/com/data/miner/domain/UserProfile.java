package com.data.miner.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
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

    private List<String> subreddit;

    private Boolean nsfw_tag;

    public static UserProfile userProfile(String username, List<String> subreddit, Boolean nsfw_tag) {
        return new UserProfile(
                UUID.randomUUID().toString(), username, subreddit, nsfw_tag);
    }
}
