package br.com.lelo.twclient.service.auth;

import br.com.lelo.twclient.domain.UserApp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TokenCommandService {

    public String extractLogin(String token) {
        return JWT.decode(token)
                .getClaim("login")
                .asString();
    }

    public String generateToken(UserApp userApp) {
        return JWT
                .create()
                .withClaim("login", userApp.getLogin())
                .withExpiresAt(Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)))
                .sign(Algorithm.HMAC256(userApp.getPassword()));
    }
}
