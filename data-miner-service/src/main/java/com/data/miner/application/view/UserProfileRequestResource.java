package com.data.miner.application.view;

import com.data.miner.domain.UserProfile;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserProfileRequestResource {

    @NotNull
    private String username;

    @NotEmpty
    private List<String> subreddit;

    @NotNull
    private Boolean nsfw_tag;

    public UserProfile toDomain() {
        return UserProfile.userProfile(
                this.username,
                this.subreddit,
                this.nsfw_tag);
    }
}
