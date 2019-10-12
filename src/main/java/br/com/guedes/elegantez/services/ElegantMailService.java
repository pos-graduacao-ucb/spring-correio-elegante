package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.repositories.ElegantMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElegantMailService {

    @Autowired
    private ElegantMailRepository repository;

    public List<ElegantMail> findAll() {
        return repository.findAll();
    }


}
