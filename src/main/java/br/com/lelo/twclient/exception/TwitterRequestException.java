package br.com.lelo.twclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TwitterRequestException extends RuntimeException {

    public TwitterRequestException(Throwable cause) {
        super(cause);
    }

}
