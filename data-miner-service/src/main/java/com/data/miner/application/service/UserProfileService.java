package com.data.miner.application.service;

import com.data.miner.domain.UserProfile;
import com.data.miner.domain.repository.UserProfileRepository;
import com.data.miner.domain.update.UserProfileUpdate;
import com.data.miner.utils.ObjectMerger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserProfileService {

    private UserProfileRepository userProfileRepository;

    private final ObjectMerger objectMerger;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository, ObjectMerger objectMerger) {
        this.userProfileRepository = userProfileRepository;
        this.objectMerger = objectMerger;
    }

    public UserProfile create(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    public UserProfile retrieveUserProfileById(String id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile updateData(String id, Map<String, Object> input) {

        UserProfile existingUserProfile = retrieveUserProfileById(id);

        UserProfileUpdate updatableFields = UserProfileUpdate.from(existingUserProfile);

        UserProfileUpdate mergedUpdateData = objectMerger.beginMergeWith(updatableFields, UserProfileUpdate.class)
                .thenMerge(input)
                .extractResult();

        UserProfile updatedUserProfile = existingUserProfile.updateWith(mergedUpdateData);

        return userProfileRepository.save(updatedUserProfile);
    }
}
