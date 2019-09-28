package br.com.guedes.elegantez.repositories;

import br.com.guedes.elegantez.domain.ElegantMail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElegantMailRepository extends MongoRepository<ElegantMail, String> {}
