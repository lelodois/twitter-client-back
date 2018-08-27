package br.com.lelo.twclient.external.bridge;

import br.com.lelo.twclient.config.TwitterEndpointProperties;
import br.com.lelo.twclient.exception.TwitterRequestException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class TweetBridgeRequest {

    private final String UTF8 = "UTF-8";
    private final String HMAC_SHA1 = "HmacSHA1";

    @Autowired
    private TwitterEndpointProperties prop;

    public String get(String hashtag) {
        try {
            HttpResponse response = this.call(hashtag);
            int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != statusCode) {
                throw new Exception("Request returned: " + statusCode);
            }
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw new TwitterRequestException(e);
        }
    }

    private HttpResponse call(String hashtag) throws Exception {

        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(this.neww("oauth_consumer_key", prop.getTwKey()));
        pairs.add(this.neww("oauth_nonce", Math.random() * 100000000));
        pairs.add(this.neww("oauth_signature_method", "HMAC-SHA1"));
        pairs.add(this.neww("oauth_timestamp", System.currentTimeMillis() / 1000));
        pairs.add(this.neww("oauth_version", "1.0"));
        pairs.add(this.neww("q", hashtag));

        pairs.add(this.neww("oauth_signature",
                this.getSignature(
                        URLEncoder.encode(prop.getTwFullUrl(), UTF8),
                        URLEncoder.encode(
                                URLEncodedUtils.format(pairs, UTF8), UTF8)
                )));

        return HttpClientBuilder
                .create()
                .build()
                .execute(new HttpGet(
                        new URIBuilder()
                                .setScheme("https")
                                .setHost(prop.getTwHost())
                                .setPath(prop.getTwPath())
                                .setQuery(URLEncodedUtils.format(pairs, UTF8))
                                .build()
                ));
    }

    private String getSignature(String url, String params) throws Exception {

        StringBuilder base = new StringBuilder();
        base.append("GET&").append(url).append("&").append(params);
        byte[] baseEnc = base.toString().getBytes(UTF8);
        byte[] keyBytes = (prop.getTwSecret() + "&").getBytes(UTF8);

        Mac hmacSha1 = Mac.getInstance(HMAC_SHA1);
        hmacSha1.init(new SecretKeySpec(keyBytes, HMAC_SHA1));
        return new String(Base64Utils.encode(hmacSha1.doFinal(baseEnc)), UTF8).trim();
    }

    private BasicNameValuePair neww(String key, Object value) {
        return new BasicNameValuePair(key, value.toString());
    }
}