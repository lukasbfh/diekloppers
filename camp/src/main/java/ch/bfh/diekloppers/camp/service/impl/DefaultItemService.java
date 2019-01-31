package ch.bfh.diekloppers.camp.service.impl;

import ch.bfh.diekloppers.camp.model.Item;
import ch.bfh.diekloppers.camp.repository.ItemRepository;
import ch.bfh.diekloppers.camp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultItemService implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(String name, Integer atk, Integer def){
        System.out.println("Creating item with name "+name+"...");
        Item item = new Item();
        item.setName(name);

        item.setAtk(atk);
        System.out.println(name+" has ATK value of "+item.getAtk());

        item.setDef(def);
        System.out.println(name+" has DEF value of "+item.getDef());

        String id = itemRepository.save(item).getId();

        System.out.println("Item "+name+" has been created");

        return itemRepository.findById(id).get();
    }
}
