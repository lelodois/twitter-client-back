package br.com.lelodois;

import br.com.lelo.twclient.MainApplication;
import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.service.tweet.TweetQueryService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration(classes = {MainApplication.class, TestConfigurationMockBeans.class})
public class IntegrationApplicationTests {

    @Autowired
    private TweetQueryService tweetQueryService;

    @Test
    public void assertEqualsCountCoutry() {
        List<Top> collect = tweetQueryService.countByCountry()
                .collect(Collectors.toList());

        Assert.assertThat(collect.size(), Matchers.is(1));
        Top top = collect.iterator().next();

        Assert.assertEquals("en", top.getName());
        Assert.assertEquals("1", top.getSize().toString());
    }

    @Test
    public void assertEqualsCountHourOfDay() {
        List<Top> collect = tweetQueryService.countByHourOfDay()
                .collect(Collectors.toList());

        Assert.assertThat(collect.size(), Matchers.is(1));
        Top top = collect.iterator().next();

        Assert.assertEquals("18", top.getName());
        Assert.assertEquals("1", top.getSize().toString());

    }

    @Test
    public void assertEqualsFollowers() {
        List<Top> collect = tweetQueryService.countByFollwers()
                .collect(Collectors.toList());

        Assert.assertThat(collect.size(), Matchers.is(1));
        Top top = collect.iterator().next();

        Assert.assertEquals("NASA", top.getName());
        Assert.assertEquals("1", top.getSize().toString());
    }

}
