package br.com.lelo.twclient.service.converter;

import br.com.lelo.twclient.domain.UserTweet;
import br.com.lelo.twclient.external.dto.UserTweetDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TweetUserConverterFunction implements Function<UserTweetDto, UserTweet> {

    @Override
    public UserTweet apply(UserTweetDto tweetDto) {
        UserTweet userTweet = new UserTweet();
        userTweet.setFollowersCount(tweetDto.getFollowers_count());
        userTweet.setId(tweetDto.getId());
        userTweet.setLanguage(tweetDto.getLang());
        userTweet.setLocation(tweetDto.getLocation());
        return userTweet;
    }

}
