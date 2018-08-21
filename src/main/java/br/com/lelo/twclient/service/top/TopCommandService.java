package br.com.lelo.twclient.service.top;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import br.com.lelo.twclient.repository.TopRepository;
import br.com.lelo.twclient.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static br.com.lelo.twclient.domain.TopType.*;

@Service
public class TopCommandService {

    @Autowired
    private TopRepository topRepo;

    @Autowired
    private TweetRepository tweetRepo;

    @Transactional
    public void saveAll() {
        topRepo.deleteAll();

        this.save(tweetRepo.countByHourOfDay(), HOURS);
        this.save(tweetRepo.countByCountry(), COUNTRY);
        this.save(tweetRepo.countByFollwers(), FOLLOWERS);
    }

    private void save(Stream<Top> tops, TopType topType) {
        tops.map(item -> item.withType(topType))
                .forEach(topRepo::save);
    }
}
