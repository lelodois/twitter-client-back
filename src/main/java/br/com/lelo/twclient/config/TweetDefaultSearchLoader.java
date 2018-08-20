package br.com.lelo.twclient.config;

import br.com.lelo.twclient.service.search.SearchCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TweetDefaultSearchLoader {

    @Autowired
    private SearchCommandService command;

    @Autowired
    private TwitterEndpointProperties twitterProperties;

    @PostConstruct
    public void go() {
        twitterProperties.getTwitterTweetDefault()
                .parallelStream()
                .forEach(command::newSearch);
    }

}
