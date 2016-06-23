package com.data.miner.domain.update;

import com.data.miner.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserProfileUpdate {

    private String username;

    private int age;

    private List<String> interest;

    public static UserProfileUpdate from(UserProfile existingUserProfile) {
        return new UserProfileUpdate(existingUserProfile.getUsername(), existingUserProfile.getAge(), existingUserProfile.getInterest());
    }
}
