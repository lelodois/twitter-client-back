package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TweetLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(
                    "EEE MMM dd HH:mm:ss Z yyyy", Locale.US
            );

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        return LocalDateTime.parse(p.getText(), formatter);
    }
}
