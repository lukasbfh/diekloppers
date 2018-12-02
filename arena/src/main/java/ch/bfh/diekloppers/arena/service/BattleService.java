package ch.bfh.diekloppers.arena.service;

import ch.bfh.diekloppers.arena.model.Party;

public interface BattleService {

    String battle(Party challengee, Party challenger);
}
