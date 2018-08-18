package br.com.lelo.twclient.service.converter;

import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.external.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TweetConverterFuncion implements Function<TweetDto, Tweet> {

    @Autowired
    private TweetUserConverterFunction userConverter;

    @Override
    public Tweet apply(TweetDto tweetDto) {
        Tweet tweet = new Tweet();
        //tweet.setCreationDate(tweetDto.getCreated_at());
        tweet.setIdTweet(tweetDto.getId());
        tweet.setText(tweetDto.getText());
        tweet.setUserTweet(userConverter.apply(tweetDto.getUser()));
        return tweet;
    }

}
