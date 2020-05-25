package com.niranjan.unittesting.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MatchersTest {

  @Test
  public void learning() {
    final List<Integer> integers = Arrays.asList(12, 30, 45);

    assertThat(integers, hasSize(3));
    assertThat(integers, hasItems(12,30));
    assertThat(integers, everyItem(greaterThan(10)));
    assertThat(integers, everyItem(lessThan(100)));

    assertThat("", emptyString());
    assertThat("ABCDEF", containsString("AB"));
    assertThat("ABCDEF", startsWith("AB"));
    assertThat("ABCDEF", endsWith("EF"));

  }
}
