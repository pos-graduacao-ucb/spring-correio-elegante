package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.repositories.ElegantMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElegantMailService {

    @Autowired
    private ElegantMailRepository repository;

    public List<ElegantMail> findAll() {
        return repository.findAll();
    }

    public Page<ElegantMail> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
