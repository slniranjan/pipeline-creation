package com.niranjan.unittesting.unittest.springboot.business;

import com.niranjan.unittesting.unittest.springboot.model.Item;
import com.niranjan.unittesting.unittest.springboot.data.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

  @Autowired
  private ItemRepository itemRepository;

  public Item retrieveHardCodedItems() {
    return new Item(1, "Ball 1", 450, 5);
  }

  public List<Item> retrieveAllItems() {
    final List<Item> allItems = itemRepository.findAll();

    allItems.stream()
        .forEach(item -> item.setValue(item.getPrice()*item.getQnt()));
    return allItems;
  }

}
