package br.com.lelo.twclient.config;

import br.com.lelo.twclient.service.search.SearchCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@DependsOn(value = {"userAppLoader"})
public class TweetDefaultSearchLoader {

    @Autowired
    private SearchCommandService command;

    @Autowired
    private TwitterEndpointProperties twitterProperties;

    @PostConstruct
    public void go() {
        twitterProperties.getTwitterTweetDefault()
                .parallelStream()
                .forEach(hashtag -> command.newSearch(1L, hashtag));
    }

}
