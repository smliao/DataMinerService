package com.data.miner.domain.repository;

import com.data.miner.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String>{
    UserProfile findById(String id);
}
