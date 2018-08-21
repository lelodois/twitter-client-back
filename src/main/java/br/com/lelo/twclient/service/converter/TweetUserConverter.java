package br.com.lelo.twclient.service.converter;

import br.com.lelo.twclient.domain.TweetUser;
import br.com.lelo.twclient.external.dto.UserTweetDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TweetUserConverter implements Function<UserTweetDto, TweetUser> {

    @Override
    public TweetUser apply(UserTweetDto tweetDto) {
        TweetUser userTweet = new TweetUser();
        userTweet.setId(tweetDto.getId());
        userTweet.setName(tweetDto.getName());
        userTweet.setFollowersCount(tweetDto.getFollowers_count());
        userTweet.setCreationDate(tweetDto.getCreated_at());
        userTweet.setLanguage(tweetDto.getLang());
        userTweet.setLocation(tweetDto.getLocation());
        return userTweet;
    }

}
