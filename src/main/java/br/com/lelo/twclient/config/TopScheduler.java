package br.com.lelo.twclient.config;

import br.com.lelo.twclient.service.top.TopCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TopScheduler {

    @Autowired
    private TopCommandService commandService;

    Logger logger = LoggerFactory.getLogger(TopScheduler.class);

    @Scheduled(fixedDelay = 5000)
    public void go() {
        logger.info("Running tops");
        commandService.saveAll();
    }
}
