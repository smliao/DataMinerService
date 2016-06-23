package com.data.miner.domain;

import com.data.miner.domain.update.UserProfileUpdate;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserProfileTest {

    @Test
    public void shouldUpdateWith() throws Exception {
        //given
        UserProfile user = new UserProfile("123", "Bill", 22, asList("hiking", "swimming"));

        UserProfileUpdate updateData = new UserProfileUpdate("Steven", 22, asList("reddit", "sleeping"));

        //when
        UserProfile updatedUserProfile = user.updateWith(updateData);

        //then
        assertThat(updatedUserProfile.getUsername(), is("Steven"));
        assertThat(updatedUserProfile.getAge(), is(22));
        assertThat(updatedUserProfile.getInterest(), is(asList("reddit", "sleeping")));
    }


}
