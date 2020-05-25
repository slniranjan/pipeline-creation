package com.niranjan.unittesting.unittest.springboot.data;

import com.niranjan.unittesting.unittest.springboot.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
