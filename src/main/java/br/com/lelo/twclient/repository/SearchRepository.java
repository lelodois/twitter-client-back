package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Search;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface SearchRepository extends Repository<Search, Long> {

    Search save(Search task);
}
