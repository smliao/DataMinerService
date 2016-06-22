package com.data.miner.application.view;


import com.data.miner.domain.UserProfile;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nullable;
import java.util.List;

@AllArgsConstructor
@Data
public class UserProfileResponseResource {

    private String username;

    private List<String> subreddit;

    private Boolean nsfw_tag;

    public static UserProfileResponseResource toResource(UserProfile userProfile) {
        return new UserProfileResponseResource(userProfile.getUsername(), userProfile.getSubreddit(), userProfile.getNsfw_tag());
    }

    public static List<UserProfileResponseResource> toResourceList(List<UserProfile> userProfiles) {

        return Lists.transform(userProfiles, new Function<UserProfile, UserProfileResponseResource>() {
            @Override
            public UserProfileResponseResource apply(@Nullable UserProfile input) {
                assert input != null;
                return new UserProfileResponseResource(input.getUsername(), input.getSubreddit(), input.getNsfw_tag());
            }
        });
    }
}
