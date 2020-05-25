package com.niranjan.unittesting.unittest.springboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.niranjan.unittesting.unittest.springboot.business.ItemBusinessService;
import com.niranjan.unittesting.unittest.springboot.model.Item;
import com.niranjan.unittesting.unittest.springboot.model.ItemController;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ItemBusinessService itemBusinessService;

  @Test
  public void dummyItem_basic() throws Exception {

    /*
     * With json assert we can use original json message (without escape characters)
     * If strict true expected and actual must be same json (spaces inside okay)
     * Escape characters only need if json like {name: Ball 2}
     * */
    final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
        .accept(MediaType.APPLICATION_JSON);
    final MvcResult mvcResult = mockMvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json("{id:1, name: \"Ball 1\", price :450, qnt:5, value:0}", true))
        .andReturn();
  }

  @Test
  public void itemFromBusinessService_basic() throws Exception {

    when(itemBusinessService.retrieveHardCodedItems())
        .thenReturn(new Item(2, "Item 2", 900, 2));

    final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
        .get("/item-from-business-service")
        .accept(MediaType.APPLICATION_JSON);
    final MvcResult mvcResult = mockMvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json("{id:2, name: \"Item 2\", price :900, qnt:2, value:0}", true))
        .andReturn();
  }

  @Test
  public void retrieveAllItems_basic() throws Exception {

    when(itemBusinessService.retrieveAllItems())
        .thenReturn(
            Arrays.asList(
                new Item(2, "Item 2", 900, 2),
                new Item(3, "Item3", 200, 3)
            )
        );

    final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
        .get("/all-items-from-db")
        .accept(MediaType.APPLICATION_JSON);
    final MvcResult mvcResult = mockMvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json(
            "[{id:2, name: \"Item 2\", price :900, qnt:2},"
                + "{id:3, name:Item3, price:200, qnt:3}]"))
        .andReturn();
  }
}
