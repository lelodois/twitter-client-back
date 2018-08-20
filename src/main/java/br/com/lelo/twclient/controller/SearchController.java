package br.com.lelo.twclient.controller;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.service.search.SearchCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/search/")
public class SearchController {

    @Autowired
    private SearchCommandService command;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Search search(@Valid @RequestBody String hashtag) {
        return command.newSearch(hashtag);
    }

}
