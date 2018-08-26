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
    private String twitterSearchByHashtag;
    private String twitterAuthConumerKey;
    private String twitterAuthToken;
    private String twitterAuthSignature;

    private List<String> twitterTweetDefault = Lists.newArrayList();

    public String getTwitterAuthConumerKey() {
        return twitterAuthConumerKey;
    }

    public void setTwitterAuthConumerKey(String twitterAuthConumerKey) {
        this.twitterAuthConumerKey = twitterAuthConumerKey;
    }

    public String getTwitterAuthToken() {
        return twitterAuthToken;
    }

    public void setTwitterAuthToken(String twitterAuthToken) {
        this.twitterAuthToken = twitterAuthToken;
    }

    public String getTwitterAuthSignature() {
        return twitterAuthSignature;
    }

    public void setTwitterAuthSignature(String twitterAuthSignature) {
        this.twitterAuthSignature = twitterAuthSignature;
    }

    public List<String> getTwitterTweetDefault() {
        return twitterTweetDefault;
    }

    public void setTwitterTweetDefault(List<String> twitterTweetDefault) {
        this.twitterTweetDefault = twitterTweetDefault;
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
