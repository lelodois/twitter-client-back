package br.com.lelo.twclient.service.tweet;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.external.bridge.TweetBridge;
import br.com.lelo.twclient.external.dto.TweetResultDto;
import br.com.lelo.twclient.service.converter.TweetConverter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetCommandService {

    @Autowired
    private TweetBridge tweetBridge;

    @Autowired
    private TweetConverter tweetConverter;

    public List<Tweet> saveSearchByHash(Search search) {
        List<Tweet> tweets = Lists.newArrayList();

        TweetResultDto tweetResu = tweetBridge.findByHash(search.getHashtag());
        tweetResu.getStatuses()
                .parallelStream()
                .map(tweetConverter)
                .forEach(tweets::add);

        search.setTwitterInfo(!tweetResu.isMocked());
        return tweets;
    }

}
