package br.com.lelo.twclient.config;

import br.com.lelo.twclient.service.search.SearchCommandService;
import br.com.lelo.twclient.service.top.TopCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TweetLoader {

    @Autowired
    private SearchCommandService command;

    @Autowired
    private TwitterEndpointProperties twitterProperties;

    @Autowired
    private TopCommandService commandService;

    Logger logger = LoggerFactory.getLogger(TweetLoader.class);

    @EventListener(ApplicationReadyEvent.class)
    public void postConstruct() {
        twitterProperties.getTwitterTweetDefault()
                .forEach(command::newSearch);
    }

    @Scheduled(fixedDelay = 10000)
    public void scheduleTask() {
        logger.info("Start tops");
        commandService.saveAll();
        logger.info("Finish tops");
    }

}
