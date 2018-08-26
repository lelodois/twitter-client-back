package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTweetDto {

    private Long id;
    private String name;
    private String screen_name;
    private String location;
    private Long followers_count;
    private Long friends_count;
    private String lang;

    @JsonDeserialize(using = TweetLocalDateTimeDeserializer.class)
    private LocalDateTime created_at;

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Long followers_count) {
        this.followers_count = followers_count;
    }

    public Long getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(Long friends_count) {
        this.friends_count = friends_count;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
