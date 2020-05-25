package com.niranjan.unittesting.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AssertJTest {

  @Test
  public void learning() {
    final List<Integer> integers = Arrays.asList(12, 30, 45);

    assertThat(integers).hasSize(3).contains(12, 45)
        .allMatch(x -> x > 10)
        .allMatch(x -> x < 100)
        .noneMatch(x -> x < 0);

    assertThat("").isEmpty();
    assertThat("ABCDEF")
        .contains("BC")
        .startsWith("AB")
        .endsWith("EF");
  }
}
