package com.niranjan.unittesting.unittest.springboot.data;
/*
 *No need to write unit test for the empty repository. If we have write custom queries
 * then this method is suitable.
 * */

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.niranjan.unittesting.unittest.springboot.model.Item;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void testFindAll() {
    final List<Item> items = itemRepository.findAll();
    assertEquals(3, items.size());
  }
}
