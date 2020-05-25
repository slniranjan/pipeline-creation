package com.niranjan.unittesting.unittest.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
*@TestPropertySource(locations = {"classpath:test-configuration.properties"})
* If need to use test specific configuration use above syntax
* File should create in src->test->resources folder
* This will assign highest priority for the test configuration
* */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void contextLoad() throws Exception{
    final String response = this.testRestTemplate.getForObject("/all-items-from-db", String.class);
    JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
  }

}
