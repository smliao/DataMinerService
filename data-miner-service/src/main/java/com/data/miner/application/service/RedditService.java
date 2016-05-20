package com.data.miner.application.service;

import com.data.miner.application.service.reddit.dto.SubRedditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RedditService {

    @Autowired
    private RestTemplate restTemplate;

    public SubRedditDto retrieveSubreddit(String subreddit) {

        URI uri = buildURIFor(subreddit);

        return restTemplate.getForEntity(uri, SubRedditDto.class).getBody();
    }

    public URI buildURIFor(String subreddit) {
        String url = String.format("http://www.reddit.com/r/%s/top.json?sort=top&t=month", subreddit);

        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }
}
