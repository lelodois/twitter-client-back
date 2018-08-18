package br.com.lelo.twclient.service.auth;

import br.com.lelo.twclient.domain.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class UserAppCommandService {

    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private TokenCommandService tokenCommandService;

    @Transactional
    public UserApp save(UserApp userApp) {
        return this.userAppRepository.save(userApp);
    }

    @Transactional
    public Optional<String> newToken(UserApp userApp) {

        userApp = this.userAppRepository.findByLoginAndPassword(
                userApp.getLogin(),
                userApp.getPassword());

        if (userApp != null) {
            userApp.setLastLogin(new Date());
            userAppRepository.save(userApp);
            return Optional.of(
                    tokenCommandService.generateToken(userApp));
        }

        return Optional.empty();
    }

    @Transactional
    public UserApp getUser(String token) {
        return userAppRepository.findByLogin(
                tokenCommandService.extractLogin(token));
    }

}
