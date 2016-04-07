package com.data.miner.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "dataminer", method = RequestMethod.GET)
public class DataMinerController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> testingSpringBootApplication() {
        return new ResponseEntity<>("Greetings from Spring Boot!", HttpStatus.OK);
    }
}
