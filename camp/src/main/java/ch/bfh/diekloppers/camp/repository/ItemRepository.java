package ch.bfh.diekloppers.camp.repository;

import ch.bfh.diekloppers.camp.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ItemRepository extends MongoRepository<Item, String> { }
