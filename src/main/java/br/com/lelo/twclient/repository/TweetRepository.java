package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.Tweet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TweetRepository extends Repository<Tweet, Long> {

    /**
    @Query(
            value = "SELECT " +
                    "   count (T.id)            as size, " +
                    "   T.tweetUser.language    as name " +
                    "FROM Tweet t " +
                    "Order by 1 desc"
    )
    List<Top> countByCountry(Pageable pageable);

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "   count (T.id)            as size, " +
                    "   HOUR(T.creationDate)    as name " +
                    "FROM Tweet t " +
                    "Order by 1 desc"
    )
    List<Top> countByHourOfDay(Pageable pageable);


    @Query(
            value = "SELECT " +
                    "   count (T.tweetUser.followersCount)  as size, " +
                    "   T.tweetUser.name                    as name " +
                    "FROM Tweet t " +
                    "Order by 1 desc"
    )
    List<Top> countByFollwers(Pageable pageable);
     **/

}
