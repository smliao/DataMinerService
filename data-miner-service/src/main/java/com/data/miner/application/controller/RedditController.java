package com.data.miner.application.controller;

import com.data.miner.application.controller.paths.RedditUrlPaths;
import com.data.miner.application.service.RedditService;
import com.data.miner.application.service.reddit.dto.SubRedditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RedditUrlPaths.REDDIT_BASE_URL, method = RequestMethod.GET)
public class RedditController {

    @Autowired
    private RedditService redditService;

    @RequestMapping(value = RedditUrlPaths.SUBREDDIT, method = RequestMethod.GET)
    public ResponseEntity<SubRedditDto> retrieveBySubReddit(@PathVariable String subreddit) {

        SubRedditDto subRedditDtoResponse = redditService.retrieveSubreddit(subreddit);

        return new ResponseEntity<>(subRedditDtoResponse, HttpStatus.OK);
    }
}
