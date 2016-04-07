package com.data.miner.application.controller;

import com.data.miner.application.controller.paths.UrlPaths;
import com.data.miner.application.service.UserProfileService;
import com.data.miner.application.view.UserProfileRequestResource;
import com.data.miner.application.view.UserProfileResponseResource;
import com.data.miner.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UrlPaths.ROOT_PATH, method = RequestMethod.GET)
public class DataMinerController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = UrlPaths.TEST, method = RequestMethod.GET)
    public ResponseEntity<String> testingSpringBootApplication() {
        return new ResponseEntity<>("Greetings from Spring Boot!", HttpStatus.OK);
    }

    @RequestMapping(value = UrlPaths.CREATE_PROFILE, method = RequestMethod.POST)
    public ResponseEntity<UserProfileResponseResource> create(@RequestBody UserProfileRequestResource userProfileRequestResource){
        UserProfile userProfile = userProfileRequestResource.toDomain();

        UserProfile createdUserProfile = userProfileService.create(userProfile);

        UserProfileResponseResource result = UserProfileResponseResource.toResource(createdUserProfile);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
