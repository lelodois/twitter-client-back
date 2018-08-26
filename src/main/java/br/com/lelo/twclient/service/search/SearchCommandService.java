package br.com.lelo.twclient.service.search;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.exception.TwitterRequestException;
import br.com.lelo.twclient.repository.SearchRepository;
import br.com.lelo.twclient.service.tweet.TweetCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
public class SearchCommandService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private TweetCommandService tweetCommandService;

    public Search newSearch(String hashtag) {
        hashtag = this.getEncodedHashtag(hashtag);

        Optional<Search> searchByCache = this.getSearchByCache(hashtag);

        if (!searchByCache.isPresent()) {
            searchByCache = Optional.of(
                    this.execSearchOnTwitter(hashtag));
        }
        return searchByCache.get();
    }

    public Optional<Search> getSearchByCache(String hashtag) {
        return searchRepository.
                getFirstByHashtagAndExpirationGreaterThan(hashtag, now());

    }

    public Search execSearchOnTwitter(String hashtag) {
        Search search = searchRepository.save(new Search(hashtag));

        tweetCommandService.saveSearchByHash(search)
                .stream()
                .forEach(search::addTweet);

        search.setExpiration(now().plusMinutes(5));
        search.setExecutionDate(new Date());
        return searchRepository.save(search);
    }

    private String getEncodedHashtag(String hashtag) {
        try {
            return UriUtils.encode(hashtag.toLowerCase(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TwitterRequestException(e);
        }
    }
}
