package br.com.lelo.twclient.external.bridge;

import br.com.lelo.twclient.exception.TwitterResponseConvertException;
import br.com.lelo.twclient.external.dto.TweetResultDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TweetBridge {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TweetBridgeRequest bridgeRequest;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TweetResultDto findByHash(String hashTag) {
        String jsonResult = bridgeRequest.get(hashTag);

        try {
            return mapper.readValue(jsonResult, TweetResultDto.class);
        } catch (Throwable e) {
            logger.error("Error for convert response: " + jsonResult, e);
            throw new TwitterResponseConvertException(e);
        }
    }

    public void setBridgeRequest(TweetBridgeRequest bridgeRequest) {
        this.bridgeRequest = bridgeRequest;
    }
}
