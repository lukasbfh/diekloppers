package ch.bfh.diekloppers.camp.config;

import ch.bfh.diekloppers.camp.service.HeroService;
import ch.bfh.diekloppers.camp.service.PartyService;
import ch.bfh.diekloppers.camp.service.ItemService;
import ch.bfh.diekloppers.camp.service.impl.DefaultHeroService;
import ch.bfh.diekloppers.camp.service.impl.DefaultItemService;
import ch.bfh.diekloppers.camp.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new DefaultPartyService();
    }

    @Bean
    public ItemService itemService() {return new DefaultItemService(); }
}
