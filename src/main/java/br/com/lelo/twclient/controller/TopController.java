package br.com.lelo.twclient.controller;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import br.com.lelo.twclient.service.top.TopQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/top/")
public class TopController {

    @Autowired
    private TopQueryService service;

    @GetMapping("hours")
    @ResponseStatus(HttpStatus.OK)
    public List<Top> findTopHours() {
        return service.findByType(TopType.HOURS);
    }

    @GetMapping("followers")
    @ResponseStatus(HttpStatus.OK)
    public List<Top> findTopFollowers() {
        return service.findByType(TopType.FOLLOWERS);
    }

    @GetMapping("country")
    @ResponseStatus(HttpStatus.OK)
    public List<Top> findTopCountry() {
        return service.findByType(TopType.COUNTRY);
    }

}
