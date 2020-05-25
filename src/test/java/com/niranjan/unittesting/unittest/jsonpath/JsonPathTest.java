package com.niranjan.unittesting.unittest.jsonpath;

import static org.assertj.core.api.Assertions.assertThat;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JsonPathTest {

  @Test
  public void learning() {
    String responseFromService = "["
        + "  {\"id\": 1000, \"name\": \"pencil\", \"quantity\": 5},"
        + "  {\"id\": 1001, \"name\": \"pen\", \"quantity\": 6},"
        + "  {\"id\": 1002, \"name\": \"eraser\", \"quantity\": 7}"
        + "]";

    final DocumentContext context = JsonPath.parse(responseFromService);
    final int length = context.read("$.length()");
    assertThat(length).isEqualTo(3);

    final List<Integer> ids = context.read("$..id");
    assertThat(ids).containsExactly(1000,1001,1002);

    System.out.println(context.read("$.[1]").toString());
    System.out.println(context.read("$.[0:2]").toString());
  }

}
