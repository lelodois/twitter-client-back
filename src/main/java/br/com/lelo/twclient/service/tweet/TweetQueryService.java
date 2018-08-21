package br.com.lelo.twclient.service.tweet;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TweetQueryService {

    @Autowired
    private TweetRepository tweetRepository;

    private Pageable pageable = new PageRequest(0, 5);

    public Stream<Top> countByHourOfDay() {
        return tweetRepository.countByHourOfDay(pageable);
    }

    public Stream<Top> countByCountry() {
        return tweetRepository.countByCountry(pageable);
    }

    public Stream<Top> countByFollwers() {
        return tweetRepository.countByFollwers(pageable);
    }
}
