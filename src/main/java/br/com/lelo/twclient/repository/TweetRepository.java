package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.Tweet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

@org.springframework.stereotype.Repository
public interface TweetRepository extends Repository<Tweet, Long> {

    @Query(
            value = "SELECT " +
                    "   new br.com.lelo.twclient.domain.Top" +
                    "   (" +
                    "       count (t.id)," +
                    "       t.tweetUser.language" +
                    "   ) " +
                    "FROM Tweet t " +
                    "group by t.tweetUser.language " +
                    "Order by 1 desc"
    )
    Stream<Top> countByCountry();

    @Query(
            value = "SELECT " +
                    "   new br.com.lelo.twclient.domain.Top" +
                    "   (" +
                    "       count (t.id)," +
                    "       t.hourOfDay" +
                    "   ) " +
                    "FROM Tweet t " +
                    "group by t.hourOfDay " +
                    "Order by 1 desc"
    )
    Stream<Top> countByHourOfDay();


    @Query(
            value = "SELECT " +
                    "   new br.com.lelo.twclient.domain.Top" +
                    "   (" +
                    "       count (t.tweetUser.followersCount)," +
                    "       t.tweetUser.name                  " +
                    "   )" +
                    "FROM Tweet t " +
                    "group by t.tweetUser.name " +
                    "Order by 1 desc"
    )
    Stream<Top> countByFollwers();

}
