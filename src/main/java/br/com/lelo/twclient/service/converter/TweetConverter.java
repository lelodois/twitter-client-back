package br.com.lelo.twclient.service.converter;

import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.external.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class TweetConverter implements Function<TweetDto, Tweet> {

    @Autowired
    private TweetUserConverter userConverter;

    @Override
    public Tweet apply(TweetDto tweetDto) {
        Tweet tweet = new Tweet();
        tweet.setId(tweetDto.getId());
        tweet.setText(tweetDto.getText());
        tweet.setTweetUser(userConverter.apply(tweetDto.getUser()));

        tweet.setCreationDate(tweetDto.getCreated_at());
        tweet.setHourOfDay(tweetDto.getCreated_at().getHour());
        tweet.setExpirationCacheDate(
                LocalDateTime.now().plusMinutes(5));
        return tweet;
    }

}
