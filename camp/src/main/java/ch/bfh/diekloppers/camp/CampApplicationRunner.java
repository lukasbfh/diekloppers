package ch.bfh.diekloppers.camp;

import ch.bfh.diekloppers.camp.repository.HeroRepository;
import ch.bfh.diekloppers.camp.repository.ItemRepository;
import ch.bfh.diekloppers.camp.service.HeroService;
import ch.bfh.diekloppers.camp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HeroService heroService;

    @Autowired
    private ItemService itemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (heroRepository.count() == 0) {
            heroService.createHero("Superman");
            heroService.createHero("Batman");
            heroService.createHero("Wonder Woman");
            heroService.createHero("Spiderman");
            heroService.createHero("Aquaman");
            heroService.createHero("Green Lantern");
            heroService.createHero("Flash");
            heroService.createHero("Batwoman");
        }

        //items who would be added to the hero's stats
        if (itemRepository.count() == 0) {
            itemService.createItem("The Punisher", 35, 0);
            itemService.createItem("Thunderfury, Blessed Blade of the Windseeker", 55, 0);
            itemService.createItem("Skycutter", 15, 0);
            itemService.createItem("Gift of Salaria", 5, 0);
            itemService.createItem("Lidless Wall", 0, 15);
            itemService.createItem("Stormshield", 0, 35);
            itemService.createItem("Denial", 0, 5);
            itemService.createItem("Hyrule Shield", 0, 60);
        }
    }
}
