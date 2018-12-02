package ch.bfh.diekloppers.promoter.client;

import ch.bfh.diekloppers.promoter.model.Party;
import org.springframework.hateoas.Resource;

public interface CampClient {

    Resource<Party> createParty(String name);

}
