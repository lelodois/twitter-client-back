package br.com.lelodois;

import br.com.lelo.twclient.external.bridge.TweetBridgeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfigurationMockBeans {

    @Bean
    public TweetBridgeRequest tweetBridgeRequest() {
        return new TweetBridgeRequestMock();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
