package com.data.miner.application.view;


import com.data.miner.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserProfileResponseResource {

    private List<String> subreddit;

    public static UserProfileResponseResource toResource(UserProfile userProfile){
        return new UserProfileResponseResource(userProfile.getSubreddit());
    }
}
