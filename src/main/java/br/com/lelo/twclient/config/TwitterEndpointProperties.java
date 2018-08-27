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

    private String twHost;
    private String twPath;
    private String twFullUrl;
    private String twKey;
    private String twSecret;
    private List<String> twitterTweetDefault = Lists.newArrayList();

    public List<String> getTwitterTweetDefault() {
        return twitterTweetDefault;
    }

    public String getTwHost() {
        return twHost;
    }

    public void setTwHost(String twHost) {
        this.twHost = twHost;
    }

    public String getTwPath() {
        return twPath;
    }

    public void setTwPath(String twPath) {
        this.twPath = twPath;
    }

    public String getTwFullUrl() {
        return twFullUrl;
    }

    public void setTwFullUrl(String twFullUrl) {
        this.twFullUrl = twFullUrl;
    }

    public String getTwKey() {
        return twKey;
    }

    public void setTwKey(String twKey) {
        this.twKey = twKey;
    }

    public String getTwSecret() {
        return twSecret;
    }

    public void setTwSecret(String twSecret) {
        this.twSecret = twSecret;
    }

    public void setTwitterTweetDefault(List<String> twitterTweetDefault) {
        this.twitterTweetDefault = twitterTweetDefault;
    }
}
