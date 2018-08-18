package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Tweet;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface TweetRepository extends Repository<Tweet, Long> {

}
