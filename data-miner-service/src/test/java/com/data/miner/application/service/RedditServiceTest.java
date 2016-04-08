package com.data.miner.application.service;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RedditServiceTest {

    private RedditService redditService;

    @Before
    public void setUp() throws Exception {
        redditService = new RedditService();
    }

    @Test
    public void shouldBuildURI() throws Exception {
        //given
        String subreddit = "jokes";

        //when
        URI uri = redditService.buildURIFor(subreddit);

        //then
        assertThat(uri.toString(), is("http://www.reddit.com/r/jokes/top.json?sort=top&t=month"));
    }
}
