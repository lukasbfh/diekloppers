package ch.bfh.diekloppers.camp.repository;

import ch.bfh.diekloppers.camp.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRepository extends MongoRepository<Hero, String> {

    Long countByAtkGreaterThan(Integer atk);

}
