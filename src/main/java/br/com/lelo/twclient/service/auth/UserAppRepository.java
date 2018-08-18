package br.com.lelo.twclient.service.auth;

import br.com.lelo.twclient.domain.UserApp;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
interface UserAppRepository extends Repository<UserApp, Long> {

    UserApp save(UserApp userApp);

    List<UserApp> findAll();

    UserApp findByLoginAndPassword(String login, String password);

    UserApp findByLogin(String login);
}
