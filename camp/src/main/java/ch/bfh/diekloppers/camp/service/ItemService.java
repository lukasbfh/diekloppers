package ch.bfh.diekloppers.camp.service;

import ch.bfh.diekloppers.camp.model.Item;

public interface ItemService {

    Item createItem(String name, Integer atk, Integer def);
}
