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
      final Dollar result = five.times(2);

      // assert
      assertEquals(10, result.amount);
    }

    @DisplayName("timesメソッドはオブジェクトの状態を変えない")
    @Test
    public void testMultiplication2() {
      // arrange
      final Dollar five = new Dollar(5);

      // action
      final Dollar result1 = five.times(2);

      // assert
      assertEquals(10, result1.amount);

      // action
      final Dollar result2 = five.times(3);

      // assert
      assertEquals(15, result2.amount);
    }

    @DisplayName("同じamountのときはequalsメソッドはtrueを返す")
    @Test
    public void testEquality() {
      // arrange
      Dollar dollar1 = new Dollar(5);
      Dollar dollar2 = new Dollar(5);

      // action
      // assert
      assertTrue(dollar1.equals(dollar2));
    }

    @DisplayName("違うamountのときはequalsメソッドはtrueを返す")
    @Test
    public void testEquality2() {
      // arrange
      Dollar dollar1 = new Dollar(5);
      Dollar dollar2 = new Dollar(6);

      // action
      // assert
      assertFalse(dollar1.equals(dollar2));
    }

  }
}
