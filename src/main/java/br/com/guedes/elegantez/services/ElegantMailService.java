package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.repositories.ElegantMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElegantMailService {

    @Autowired
    private ElegantMailRepository repository;
}
