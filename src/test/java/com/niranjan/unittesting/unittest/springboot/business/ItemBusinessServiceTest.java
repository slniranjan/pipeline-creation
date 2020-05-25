package com.niranjan.unittesting.unittest.springboot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.niranjan.unittesting.unittest.springboot.model.Item;
import com.niranjan.unittesting.unittest.springboot.data.ItemRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

  @InjectMocks
  ItemBusinessService itemBusinessService;

  @Mock
  ItemRepository itemRepository;

  @Test
  public void retrieveAllItem_basic() {
    when(itemRepository.findAll()).thenReturn(
        Arrays.asList(
            new Item(2, "Item 2", 900, 2),
            new Item(3, "Item3", 200, 3))
        );
    final List<Item> items = itemBusinessService.retrieveAllItems();
    assertEquals(1800, items.get(0).getValue());
    assertEquals(600, items.get(1).getValue());

  }

}
