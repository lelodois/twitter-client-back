package br.com.lelo.twclient.controller;

import br.com.lelo.twclient.domain.UserApp;
import br.com.lelo.twclient.service.auth.UserAppCommandService;
import br.com.lelo.twclient.service.auth.UserAppQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/v1/api/auth/")
public class AuthController {

    @Autowired
    private UserAppCommandService userCommandService;

    @Autowired
    private UserAppQueryService userQueryService;

    @PostMapping
    public UserApp token(@Valid @RequestBody UserApp userApp) {
        Optional<String> token = userCommandService.newToken(userApp);
        if (token.isPresent()) {
            userApp.setToken(token.get());
        }
        return userApp;
    }

    @PostMapping("user-token/")
    public UserApp getUserByToken(@Valid @RequestBody UserApp userAppToken) {
        return userCommandService.getUser(userAppToken.getToken());
    }

    @GetMapping
    public Iterable<UserApp> list() {
        return userQueryService.userFindAll();
    }


}
