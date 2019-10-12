package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.repositories.ElegantMailRepository;
import br.com.guedes.elegantez.repositories.UserRepository;
import br.com.guedes.elegantez.security.UserSS;
import br.com.guedes.elegantez.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElegantMailService {

    @Autowired
    private ElegantMailRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<ElegantMail> findAll() {
        return repository.findAll();
    }

    public Page<ElegantMail> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS userSS = UserService.authenticated();

        if(userSS == null) {
            throw new AuthorizationException("Acesso negado");
        }

        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Optional<User> user = userRepository.findById(userSS.getId());

        return repository.findByUser(user, pageRequest);
    }
}
