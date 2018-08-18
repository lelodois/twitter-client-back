package br.com.lelo.twclient.config;

import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:twitter-endpoint.properties")
@ConfigurationProperties
public class TwitterEndpointProperties {

    private String twitterPath;
    private String twitterToken;
    private String twitterSearch;
    private String twitterSearchByHashtag;
    private List<String> twitterTweetDefault = Lists.newArrayList();

    public List<String> getTwitterTweetDefault() {
        return twitterTweetDefault;
    }

    public void setTwitterTweetDefault(List<String> twitterTweetDefault) {
        this.twitterTweetDefault = twitterTweetDefault;
    }

    public String getTwitterSearch() {
        return twitterSearch;
    }

    public void setTwitterSearch(String twitterSearch) {
        this.twitterSearch = twitterSearch;
    }

    public String getTwitterPath() {
        return twitterPath;
    }

    public void setTwitterPath(String twitterPath) {
        this.twitterPath = twitterPath;
    }

    public String getTwitterToken() {
        return twitterToken;
    }

    public void setTwitterToken(String twitterToken) {
        this.twitterToken = twitterToken;
    }

    public String getTwitterSearchByHashtag() {
        return twitterSearchByHashtag;
    }

    public void setTwitterSearchByHashtag(String twitterSearchByHashtag) {
        this.twitterSearchByHashtag = twitterSearchByHashtag;
    }
}
