package br.com.lelo.twclient.external.bridge;

import org.springframework.stereotype.Service;

@Service
public class TweetBridgeRequest {

//    public String get(String hashTag, String url) throws Exception {
//        return Request.Get(StringUtils.replace(url, "{hashtag}", hashTag))
//                .connectTimeout(10000)
//                .execute()
//                .returnContent()
//                .asString();
//    }

    public String get(String hashTag, String url) throws Exception {
        return "{\n" +
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
                "} ";
    }

}

