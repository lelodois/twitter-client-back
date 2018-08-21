package br.com.lelo.twclient.service.tweet;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.domain.Tweet;
import br.com.lelo.twclient.external.bridge.TwitterBridge;
import br.com.lelo.twclient.service.converter.TweetConverterFuncion;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetCommandService {

    @Autowired
    private TwitterBridge twitterBridge;
    @Autowired
    private TweetConverterFuncion tweetConverter;

    public List<Tweet> saveSearchByHash(Search search) {
        List<Tweet> tweets = Lists.newArrayList();

        twitterBridge.findByHash(search.getHashtag())
                .parallelStream()
                .map(tweetConverter)
                .forEach(tweets::add);

        return tweets;
    }

}
