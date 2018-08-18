package br.com.lelo.twclient.external.bridge;

import br.com.lelo.twclient.config.TwitterEndpointProperties;
import br.com.lelo.twclient.external.dto.TweetDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.replace;

@Component
public class TwitterBridge {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TwitterEndpointProperties properties;

    public List<TweetDto> findByHash(String hashTag) {
        try {
            return this.find(hashTag);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<TweetDto> find(String hashTag) throws IOException {
        String url = properties.getTwitterSearchByHashtag();

        //String asString =
        //        Request.Get(replace(url, "{hashtag}", hashTag))
        //                .connectTimeout(10000)
        //                .execute()
        //                .returnContent()
        //                .asString();


        String asString = "{\n" +
                "  \"statuses\": [\n" +
                "    {\n" +
                "      \"created_at\": \"Sun Feb 25 18:11:01 +0000 2018\",\n" +
                "      \"id\": 967824267948773400,\n" +
                "      \"text\": \"From pilot to astronaut, Robert H. Lawrence was the first African-American to be selected as an astronaut by any na… https://t.co/FjPEWnh804\",\n" +
                "      \"user\": {\n" +
                "        \"id\": 11348282,\n" +
                "        \"name\": \"NASA\",\n" +
                "        \"location\": \"\",\n" +
                "        \"followers_count\": 28605561,\n" +
                "        \"friends_count\": 270,\n" +
                "        \"created_at\": \"Wed Dec 19 20:20:32 +0000 2007\",\n" +
                "        \"statuses_count\": 50713,\n" +
                "        \"lang\": \"en\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        return Arrays.asList(mapper.readValue(asString, TweetDto[].class));
    }

}
