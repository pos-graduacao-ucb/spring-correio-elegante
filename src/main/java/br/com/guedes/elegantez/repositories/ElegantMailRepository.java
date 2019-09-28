package br.com.guedes.elegantez.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElegantMailRepository extends MongoRepository<ElegantMailRepository, String> {}
