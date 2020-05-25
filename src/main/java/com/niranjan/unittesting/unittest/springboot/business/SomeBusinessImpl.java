package com.niranjan.unittesting.unittest.springboot.business;

import com.niranjan.unittesting.unittest.springboot.data.SomeDataService;
import java.util.Arrays;

public class SomeBusinessImpl {

  private SomeDataService someDataService;

  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }

  public int calculateSum(int[] intsData) {
    return Arrays.stream(intsData).reduce(Integer::sum).orElse(0);
    //Arrays.stream(intsData).reduce(0, Integer::sum);
  }

  public int calculateSumUsingDataService() {
    return Arrays.stream(someDataService.retrieveAllData())
        .reduce(0, Integer::sum);
  }

}
