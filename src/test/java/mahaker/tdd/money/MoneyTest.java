package mahaker.tdd.money;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("moneyパッケージ内のクラスのテスト")
public class MoneyTest {

  @DisplayName("Dollarクラスのテスト")
  @Nested
  public class DollarTest {

    @DisplayName("$5の2倍は$10である")
    @Test
    public void testMultiplication() {
      // arrange
      final Dollar five = new Dollar(5);

      // action
      five.times(2);

      // assert
      assertEquals(10, five.amount);
    }
  }
}
