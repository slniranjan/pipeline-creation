package com.niranjan.unittesting.unittest.springboot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

  final List<String> mockList = mock(List.class);

  @Test
  public void sizeBasic() {
    when(mockList.size()).thenReturn(5);
    assertEquals(5, mockList.size());
  }

  @Test
  public void returnDifferentValues() {
    when(mockList.size()).thenReturn(5).thenReturn(10);
    assertEquals(5, mockList.size());
    assertEquals(10, mockList.size());
  }

  @Test
  public void returnWithParameters() {
    when(mockList.get(0)).thenReturn("niranjan");
    assertEquals("niranjan", mockList.get(0));
    assertEquals(null, mockList.get(1));
  }

  //argument matcher --> here anyInt()
  @Test
  public void returnWithGenericsParameters() {
    when(mockList.get(anyInt())).thenReturn("niranjan");
    assertEquals("niranjan", mockList.get(0));
    assertEquals("niranjan", mockList.get(10));
  }

  @Test
  public void verificationBasics() {
    /*
      Use this technique when testing method doesn't return value.
      can verify how mock method behave
    */

    /*
    In the code you want to test, get method is called  with a parameter 0.
    we want to verify this
    */
    final String value1 = mockList.get(0);
    final String value2 = mockList.get(1);
    //verify
    verify(mockList).get(0);
    verify(mockList, times(2)).get(anyInt());
    verify(mockList, atLeast(1)).get(anyInt());
    verify(mockList, atMost(2)).get(anyInt());
    verify(mockList, never()).get(8);
  }

  @Test
  public void argumentCapturing() {
    /*
    * Useful to test mock methods which are not return values
    * */
    //SUT
    mockList.add("SomeString");
    //verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mockList).add(captor.capture());

    assertEquals("SomeString", captor.getValue());
  }

  @Test
  public void multipleArgumentCapturing() {
    /*
     * Useful to test mock methods which are not return values
     * */
    //SUT
    mockList.add("SomeString1");
    mockList.add("SomeString2");
    //verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mockList, times(2)).add(captor.capture());

    final List<String> allValues = captor.getAllValues();
    assertEquals("SomeString1", allValues.get(0));
    assertEquals("SomeString2", allValues.get(1));
  }

  /*see when to use mocking and spying use cases
  * why static method, constructor mocking are bad practices
  * */

  @Test
  public void mocking() {
    final ArrayList mockArrayList = mock(ArrayList.class);
    /*
    * Mocking doesn't affect the original class. since array list doesn't change after calling
    * add method. Mock class only change if we change it manually (stubbing)
    * */
    System.out.println(mockArrayList.get(0));//null
    System.out.println(mockArrayList.size());//0
    mockArrayList.add("test1");
    mockArrayList.add("test2");
    System.out.println(mockArrayList.size());//0
    when(mockArrayList.size()).thenReturn(5);
    System.out.println(mockArrayList.size());//5
  }

  @Test
  public void spying() {
    /*
    * By default, retains behavior (code) of the original class
    * After stubbing original class behaviour lost
    * */
    final ArrayList spyArrayList = spy(ArrayList.class);
    spyArrayList.add("test0");
    System.out.println(spyArrayList.get(0));//test0
    System.out.println(spyArrayList.size());//1
    spyArrayList.add("test1");
    spyArrayList.add("test2");
    System.out.println(spyArrayList.size());//3
    when(spyArrayList.size()).thenReturn(5);
    System.out.println(spyArrayList.size());//5

    spyArrayList.add("test3");
    System.out.println(spyArrayList.size());//5
  }
}
