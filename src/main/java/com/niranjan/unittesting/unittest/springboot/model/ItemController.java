package com.niranjan.unittesting.unittest.springboot.model;

import com.niranjan.unittesting.unittest.springboot.business.ItemBusinessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @Autowired
  private ItemBusinessService itemBusinessService;

  @GetMapping("/dummy-item")
  public Item dummyItem() {
    return new Item(1, "Ball 1", 450, 5);
  }

  @GetMapping("/item-from-business-service")
  public Item itemFromBusinessService() {
    return itemBusinessService.retrieveHardCodedItems();
  }

  @GetMapping("/all-items-from-db")
  public List<Item> retrieveAllItems() {
    return itemBusinessService.retrieveAllItems();
  }
}
