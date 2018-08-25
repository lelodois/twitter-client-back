package br.com.lelodois;

import br.com.lelo.twclient.MainApplication;
import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.service.tweet.TweetQueryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Comparator;
import java.util.stream.Stream;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
@ContextConfiguration(classes = {
        MainApplication.class,
        TestConfigurationMockBeans.class
})
public class IntegrationApplicationTests {

    @Autowired
    private TweetQueryService tweetQueryService;

    @Test
    public void assertEqualsCountCoutry() {
        Stream<Top> stream = tweetQueryService.countByCountry();

        Top max = stream.max(Comparator.comparing(Top::getSize)).get();
        Assert.assertEquals("en", max.getName());
        Assert.assertEquals("4", max.getSize().toString());

    }

    @Test
    public void assertEqualsCountHourOfDay() {
        Stream<Top> stream = tweetQueryService.countByHourOfDay();

        Top max = stream.max(Comparator.comparing(Top::getSize)).get();
        Assert.assertEquals("19", max.getName());
        Assert.assertEquals("2", max.getSize().toString());
    }

    @Test
    public void assertEqualsFollowers() {
        Stream<Top> stream = tweetQueryService.countByFollwers();

        Top max = stream.max(Comparator.comparing(Top::getSize)).get();
        Assert.assertEquals("NASA", max.getName());
        Assert.assertEquals("3", max.getSize().toString());
    }

}
