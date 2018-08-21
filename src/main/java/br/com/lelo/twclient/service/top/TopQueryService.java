package br.com.lelo.twclient.service.top;

import br.com.lelo.twclient.domain.Top;
import br.com.lelo.twclient.domain.TopType;
import br.com.lelo.twclient.repository.TopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopQueryService {

    @Autowired
    private TopRepository topRepository;

    public List<Top> findByType(TopType type) {
        return topRepository.findByType(type);
    }

}
