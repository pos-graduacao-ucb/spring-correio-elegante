package br.com.guedes.elegantez.repositories;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElegantMailRepository extends MongoRepository<ElegantMail, String> {

    Page<ElegantMail> findByUser(User user, Pageable pageRequest);
}
