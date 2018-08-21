package br.com.lelo.twclient.service.top;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import br.com.lelo.twclient.repository.TopRepository;
import br.com.lelo.twclient.service.tweet.TweetQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static br.com.lelo.twclient.domain.TopType.*;

@Service
public class TopCommandService {

    @Autowired
    private TopRepository topRepository;

    @Autowired
    private TweetQueryService tweetQueryService;

    @Transactional
    public void saveAll() {
        topRepository.deleteAll();

        this.save(tweetQueryService.countByHourOfDay(), HOURS);
        this.save(tweetQueryService.countByCountry(), COUNTRY);
        this.save(tweetQueryService.countByFollwers(), FOLLOWERS);
    }

    private void save(Stream<Top> tops, TopType topType) {
        tops.map(item -> item.withType(topType))
                .forEach(topRepository::save);
    }
}
