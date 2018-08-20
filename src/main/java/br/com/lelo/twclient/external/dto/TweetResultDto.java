package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetResultDto {

    private List<TweetDto> statuses;

    public List<TweetDto> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TweetDto> statuses) {
        this.statuses = statuses;
    }
}
