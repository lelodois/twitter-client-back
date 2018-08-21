package br.com.lelodois;

import br.com.lelo.twclient.external.bridge.TwitterBridgeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;

@TestConfiguration
public class TestConfigurationMockBeans {
    
    @Bean
    public TwitterBridgeRequest twitterBridgeRequest() {
        return new TwitterBridgeRequestMock();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RequestMappingInfoHandlerMapping requestMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public ServletContext servletContext() {
        return new MockServletContext();
    }
}
