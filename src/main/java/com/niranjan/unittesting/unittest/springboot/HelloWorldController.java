package com.niranjan.unittesting.unittest.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/hello-world")
  public String helloWorld() {
    return "Hello World !!!";
  }
}
