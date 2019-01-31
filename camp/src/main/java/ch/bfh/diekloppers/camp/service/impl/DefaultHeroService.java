package ch.bfh.diekloppers.camp.service.impl;

import ch.bfh.diekloppers.camp.model.Hero;
import ch.bfh.diekloppers.camp.repository.HeroRepository;
import ch.bfh.diekloppers.camp.service.HeroService;
import ch.bfh.diekloppers.camp.repository.ItemRepository;
import ch.bfh.diekloppers.camp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class DefaultHeroService implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero createHero(String name) {
        System.out.println("Creating hero with name "+name+"...");
        Hero hero = new Hero();
        hero.setName(name);

        int atk = new Random().nextInt(100) + new Random().nextInt(50); //second rand showcase the idea behind items
        hero.setAtk(atk);
        System.out.println(name+" has ATK value of "+hero.getAtk());

        int def = new Random().nextInt(100) + new Random().nextInt(50); //second rand showcase the idea behind items
        hero.setDef(def);
        System.out.println(name+" has DEF value of "+hero.getDef());

        hero.setHp(100);
        System.out.println(name+" has HP value of "+hero.getHp());

        String id = heroRepository.save(hero).getId();

        System.out.println("Hero "+name+" has been created");
        System.out.println("Heros with ATK greater than 50: "+heroRepository.countByAtkGreaterThan(50));

        return heroRepository.findById(id).get();
    }
}
