package com.data.miner.application.service;

import com.data.miner.domain.UserProfile;
import com.data.miner.domain.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile create(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
