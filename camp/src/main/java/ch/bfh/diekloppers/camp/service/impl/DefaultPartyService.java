package ch.bfh.diekloppers.camp.service.impl;

import ch.bfh.diekloppers.camp.model.Hero;
import ch.bfh.diekloppers.camp.model.Party;
import ch.bfh.diekloppers.camp.repository.HeroRepository;
import ch.bfh.diekloppers.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class DefaultPartyService implements PartyService {

    @Autowired
    private HeroRepository heroRepository;

    public Party createParty(String name) {
        System.out.println("Creating party with name "+name+"...");
        Party party = new Party();
        party.setName(name);

        List<Hero> allHeroes = heroRepository.findAll();
        Collections.shuffle(allHeroes);
        List<Hero> randomHeroes = allHeroes.subList(0,4);

        System.out.println("Adding heroes to party "+name);
        party.setMembers(randomHeroes);
        System.out.println("Party "+name+" has been created.");
        return party;
    }
}
