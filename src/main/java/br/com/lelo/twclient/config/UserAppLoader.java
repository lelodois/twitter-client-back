package br.com.lelo.twclient.config;

import br.com.lelo.twclient.domain.UserApp;
import br.com.lelo.twclient.service.auth.UserAppCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserAppLoader {

    @Autowired
    private UserAppCommandService command;

    @PostConstruct
    public void go() {
        command.save(new UserApp("user@teste.com.br", "user"));
        command.save(new UserApp("other@teste.com.br", "user2"));
    }

}
