package br.com.lelo.twclient.repository;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TopRepository extends Repository<Top, Long> {

    Top save(Top top);

    List<Top> findByType(TopType type);

    void deleteAll();

}
