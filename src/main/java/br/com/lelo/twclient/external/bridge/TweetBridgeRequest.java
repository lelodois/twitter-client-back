package br.com.lelo.twclient.external.bridge;

import br.com.lelo.twclient.config.TwitterEndpointProperties;
import br.com.lelo.twclient.exception.TwitterRequestException;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class TweetBridgeRequest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TwitterEndpointProperties prop;

    public String get(String hashTag) {
            return this.getOnTwitter(hashTag);
    }

    public String getOnTwitter(String hashTag) {

        String authoriz = "OAuth oauth_consumer_key=\"y9q5EkqWavT1HenKhr1AYzmbk\"" +
                ",oauth_token=\"1032965391369293824-CZaKfzwtLy8QFj6KGlaZb0EnpEC5Al\"" +
                ",oauth_signature_method=\"HMAC-SHA1\"" +
                ",oauth_timestamp=\"1535248293\"" +
                ",oauth_nonce=\"T5ZqX6\"" +
                ",oauth_version=\"1.0\"" +
                ",oauth_signature=\"ZCSdX0A4zMurKEvWObdwjtJ8SjQ%3D\"";
        try {

            return Request.Get(this.getTwSearchUrl(hashTag))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", authoriz)
                    .connectTimeout(10000)
                    .execute()
                    .returnContent()
                    .asString();

        } catch (Exception e) {
            logger.error("Error for hashTag: " + hashTag, e);
            throw new TwitterRequestException(e);
        }
    }

    private String getTwSearchUrl(String hashTag) {
        return StringUtils.replace(
                prop.getTwitterSearchByHashtag(), "{hashtag}", hashTag);
    }

    private String getMocked(String hashTag) {
        try {
            String jsonMock = "mock.json";
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(jsonMock).getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException("mock.json not found");
        }
    }


}

