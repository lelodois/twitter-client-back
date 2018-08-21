package br.com.lelo.twclient.controller;

import br.com.lelo.twclient.domain.Search;
import br.com.lelo.twclient.service.search.SearchCommandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/search/")
public class SearchController {

    @Autowired
    private SearchCommandService command;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Search search(@RequestBody Search search) {
        if (search == null || StringUtils.isEmpty(search.getHashtag())) {
            throw new InvalidRequest();
        }
        
        return command.newSearch(search.getHashtag());
    }

}
