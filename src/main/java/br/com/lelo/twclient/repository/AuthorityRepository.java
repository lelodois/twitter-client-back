package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findByName(String name);

}