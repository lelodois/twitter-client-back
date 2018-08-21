package br.com.lelo.twclient.external.bridge;

import br.com.lelo.twclient.config.TwitterEndpointProperties;
import br.com.lelo.twclient.external.dto.TweetDto;
import br.com.lelo.twclient.external.dto.TweetResultDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TwitterBridge {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TwitterBridgeRequest bridgeRequest;

    @Autowired
    private TwitterEndpointProperties properties;

    public List<TweetDto> findByHash(String hashTag) {
        try {
            String jsonResult =
                    bridgeRequest.get(hashTag, properties.getTwitterSearchByHashtag());

            return mapper
                    .readValue(jsonResult, TweetResultDto.class)
                    .getStatuses();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setBridgeRequest(TwitterBridgeRequest bridgeRequest) {
        this.bridgeRequest = bridgeRequest;
    }
}
