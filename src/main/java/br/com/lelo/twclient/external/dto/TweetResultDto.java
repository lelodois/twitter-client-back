package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetResultDto {

    private List<TweetDto> statuses;
    private boolean mocked;

    public boolean isMocked() {
        return mocked;
    }

    public void setMocked(boolean mocked) {
        this.mocked = mocked;
    }

    public List<TweetDto> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TweetDto> statuses) {
        this.statuses = statuses;
    }
}
