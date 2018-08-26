package br.com.lelodois;

import br.com.lelo.twclient.external.bridge.TweetBridgeRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
public class TweetBridgeRequestMock extends TweetBridgeRequest {

    @Override
    public String get(String hashTag) {
        try {
            String jsonMock = "resources/json-twitter-mock.json";
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(jsonMock).getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException("File json-twitter-mock.json not found test/resources folder");
        }
    }
}
