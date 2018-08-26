package br.com.lelo.twclient.controller;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.service.search.SearchCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/search/")
public class SearchController {

    @Autowired
    private SearchCommandService command;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    public Search search(@RequestBody Search search) {
        if (search == null || search.getHashtag() == null) {
            throw new InvalidRequest();
        }

        return command.newSearch(search.getHashtag());
    }

}
