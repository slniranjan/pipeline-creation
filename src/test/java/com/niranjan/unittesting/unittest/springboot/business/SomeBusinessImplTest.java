package com.niranjan.unittesting.unittest.springboot.business;

import static org.mockito.Mockito.when;

import com.niranjan.unittesting.unittest.springboot.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTest {

  @InjectMocks
  SomeBusinessImpl someBusiness;

  @Mock
  SomeDataService someDataServiceMock;

  @Test
  public void calculateSumUsingDataService_basic() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
    Assertions.assertEquals(6, someBusiness.calculateSumUsingDataService());
  }

  @Test
  public void calculateSumUsingDataService_empty() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
    Assertions.assertEquals(0, someBusiness.calculateSumUsingDataService());
  }

  @Test
  public void calculateSumUsingDataService_one() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {6});
    Assertions.assertEquals(6, someBusiness.calculateSumUsingDataService());
  }

}
