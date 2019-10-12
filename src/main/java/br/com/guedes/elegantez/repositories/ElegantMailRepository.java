package br.com.guedes.elegantez.repositories;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ElegantMailRepository extends MongoRepository<ElegantMail, String> {

    @Transactional(readOnly = true)
    Page<ElegantMail> findByUser(Optional<User> user, Pageable pageRequest);
}
