package br.com.lelodois;

import br.com.lelo.twclient.external.bridge.TwitterBridgeRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
public class TwitterBridgeRequestMock extends TwitterBridgeRequest {

    @Override
    public String get(String hashTag, String url) {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource("resources/json-twitter-mock.json").getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException("File json-twitter-mock.json not found test/resources folder");
        }
    }
}
