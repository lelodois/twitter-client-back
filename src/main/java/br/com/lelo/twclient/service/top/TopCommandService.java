package br.com.lelo.twclient.service.top;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.repository.TopRepository;
import br.com.lelo.twclient.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.lelo.twclient.domain.TopType.*;

@Service
public class TopCommandService {

    @Autowired
    private TopRepository topRepo;

    @Autowired
    private TweetRepository tweetRepo;


    @Transactional(rollbackFor = Exception.class)
    public void saveAll() {
        topRepo.deleteAll();

        /**
        this.tweetRepo
                .countByCountry(new PageRequest(0, 5))
                .parallelStream()
                .map(item -> topRepo.save(item.withType(COUNTRY)));

        this.tweetRepo
                .countByHourOfDay(new PageRequest(0, 5))
                .parallelStream()
                .map(item -> topRepo.save(item.withType(HOURS)));

        this.tweetRepo.countByFollwers(new PageRequest(0, 5))
                .parallelStream()
                .map(item -> topRepo.save(new Top(FOLLOWERS, item.getName())));

         **/
    }
}
