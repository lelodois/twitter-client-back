package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetDto {

    private Long id;
    private String text;
    private UserTweetDto user;

    @JsonDeserialize(using = TweetDateDeserializer.class)
    private Date created_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
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
