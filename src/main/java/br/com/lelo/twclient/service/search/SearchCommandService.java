package br.com.lelo.twclient.service.search;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.repository.SearchRepository;
import br.com.lelo.twclient.service.tweet.TweetCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SearchCommandService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private TweetCommandService tweetCommandService;

    public Search newSearch(String hashtag) {
        Search search = searchRepository.save(new Search(hashtag));

        tweetCommandService.saveSearchByHash(search)
                .stream()
                .forEach(search::addTweet);

        search.setExecutionDate(new Date());
        return searchRepository.save(search);
    }

}
