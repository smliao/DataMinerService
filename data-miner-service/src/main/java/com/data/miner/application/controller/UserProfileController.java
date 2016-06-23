package com.data.miner.application.controller;

import com.data.miner.application.controller.paths.UrlPaths;
import com.data.miner.application.service.UserProfileService;
import com.data.miner.application.view.UserProfileRequestResource;
import com.data.miner.application.view.UserProfileResponseResource;
import com.data.miner.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UrlPaths.ROOT_PATH)
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = UrlPaths.TEST)
    public ResponseEntity<String> testingSpringBootApplication() {
        return new ResponseEntity<>("Greetings from Spring Boot!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserProfileResponseResource>> findAll() {

        List<UserProfile> userProfiles = userProfileService.findAll();

        List<UserProfileResponseResource> result = UserProfileResponseResource.toResourceList(userProfiles);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = UrlPaths.ID_PATH, method = RequestMethod.GET)
    public ResponseEntity<UserProfileResponseResource> findOne(@PathVariable String id) {

        UserProfile userProfile = userProfileService.retrieveUserProfileById(id);

        UserProfileResponseResource result = UserProfileResponseResource.toResource(userProfile);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserProfileResponseResource> create(@Valid @RequestBody UserProfileRequestResource userProfileRequestResource) {
        UserProfile userProfile = userProfileRequestResource.toDomain();

        UserProfile createdUserProfile = userProfileService.create(userProfile);

        UserProfileResponseResource result = UserProfileResponseResource.toResource(createdUserProfile);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RequestMapping(value = UrlPaths.ID_PATH, method = RequestMethod.POST)
    public ResponseEntity<UserProfileResponseResource> partialUpdate(@PathVariable String id,
                                                                     @RequestBody Map<String, Object> input) {

        UserProfile updatedUserProfile = userProfileService.updateData(id, input);

        UserProfileResponseResource result = UserProfileResponseResource.toResource(updatedUserProfile);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
