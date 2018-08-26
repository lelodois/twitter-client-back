package br.com.lelo.twclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TwitterResponseConvertException extends RuntimeException {

    public TwitterResponseConvertException(Throwable cause) {
        super(cause);
    }

}
