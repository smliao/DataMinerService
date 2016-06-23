package com.data.miner.application.view;

import com.data.miner.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserProfileRequestResource {

    @NotNull
    private String username;

    @NotNull
    private int age;

    @NotEmpty
    private List<String> subreddit;


    public UserProfile toDomain() {
        return UserProfile.userProfile(
                this.username,
                this.age,
                this.subreddit);
    }
}
