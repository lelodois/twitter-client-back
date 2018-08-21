package br.com.lelo.twclient.config;

import br.com.lelo.twclient.service.search.SearchCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TweetDefaultSearchLoader {

    @Autowired
    private SearchCommandService command;

    @Autowired
    private TwitterEndpointProperties twitterProperties;

    @EventListener(ApplicationReadyEvent.class)
    public void go() {
        twitterProperties.getTwitterTweetDefault()
                .forEach(command::newSearch);
    }

}
