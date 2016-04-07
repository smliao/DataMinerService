package com.data.miner.application.view;

import com.data.miner.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserProfileRequestResource {

    private String username;

    private List<String> subreddit;

    private Boolean nsfw_tag;

    public UserProfile toDomain() {
        return UserProfile.userProfile(
                this.username,
                this.subreddit,
                this.nsfw_tag);
    }
}
