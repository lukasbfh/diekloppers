package config;


import service.HeroService;
import service.PartyService;
import service.impl.DefaultHeroService;
import service.impl.DefaultPartyService;
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
}
