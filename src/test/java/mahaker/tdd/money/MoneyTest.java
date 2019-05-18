package mahaker.tdd.money;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("moneyパッケージ内のクラスのテスト")
public class MoneyTest {

  @DisplayName("Dollarクラスのテスト")
  @Nested
  public class DollarTest {

    @DisplayName("$5の2倍は$10であり、$5の3倍は$15である")
    @Test
    public void testMultiplication() {
      // arrange
      final Dollar five = new Dollar(5);

      // action
      // assert
      assertEquals(new Dollar(10), five.times(2));
      assertEquals(new Dollar(15), five.times(3));
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

  @DisplayName("Francクラスのテスト")
  @Nested
  public class FrancTest {

    @DisplayName("5 CHFの2倍は10 CHFであり、5 CHFの3倍は15 CHFである")
    @Test
    public void testMultiplication() {
      // arrange
      final Franc five = new Franc(5);

      // action
      // assert
      assertEquals(new Franc(10), five.times(2));
      assertEquals(new Franc(15), five.times(3));
    }

    @Disabled
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

    @Disabled
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
