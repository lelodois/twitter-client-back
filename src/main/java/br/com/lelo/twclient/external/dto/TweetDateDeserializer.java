package br.com.lelo.twclient.external.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TweetDateDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat formatter =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return formatter.parse(p.getText());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
