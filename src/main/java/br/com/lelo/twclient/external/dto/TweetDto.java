package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetDto {

    private Long id;
    private String id_str;
    private String text;
    private UserTweetDto user;

    @JsonDeserialize(using = TweetLocalDateTimeDeserializer.class)
    private LocalDateTime created_at;

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserTweetDto getUser() {
        return user;
    }

    public void setUser(UserTweetDto user) {
        this.user = user;
    }
}
