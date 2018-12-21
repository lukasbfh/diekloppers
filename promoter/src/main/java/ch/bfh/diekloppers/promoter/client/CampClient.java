package ch.bfh.diekloppers.promoter.client;

import ch.bfh.diekloppers.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("camp-service")
public interface CampClient {

    @GetMapping("/createParty")
    Resource<Party> createParty(@RequestParam(value = "name") String name);

}
