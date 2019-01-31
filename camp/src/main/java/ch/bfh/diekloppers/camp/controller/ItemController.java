package ch.bfh.diekloppers.camp.controller;

import ch.bfh.diekloppers.camp.model.Hero;
import ch.bfh.diekloppers.camp.model.Item;
import ch.bfh.diekloppers.camp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroesWOHateoas")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public @ResponseBody Iterable<Item> list() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Item getById(@PathVariable String id) {
        return itemRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        itemRepository.deleteById(id);
    }

}
