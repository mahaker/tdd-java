package mahaker.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ServiceTest {

  private final Service target = new Service();

  @Test
  public void addtion() {
    assertEquals(3, target.add(1, 2));
  }

}