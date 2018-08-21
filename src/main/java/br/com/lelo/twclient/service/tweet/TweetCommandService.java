package br.com.lelo.twclient.service.tweet;

import br.com.lelo.twclient.config.TwitterEndpointProperties;
import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.external.bridge.TweetBridge;
import br.com.lelo.twclient.service.converter.TweetConverter;
import org.assertj.core.util.Lists;
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

        tweetBridge.findByHash(search.getHashtag())
                .parallelStream()
                .map(tweetConverter)
                .forEach(tweets::add);

        return tweets;
    }

}
