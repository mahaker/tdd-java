package mahaker.tdd.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("moneyパッケージ内のクラスのテスト")
public class MoneyTest {

  @DisplayName("Moneyクラスのテスト")
  @Nested
  public class MoneyClassTest {

    @DisplayName("別の通貨同士を比較する")
    @Test
    public void testEqualityOtherMonies() {
      // arrange
      final Money dollar = Money.dollar(5);
      final Money franc = Money.franc(5);

      // action
      // assert
      assertFalse(dollar.equals(franc));
    }
  }

  @DisplayName("Dollarクラスのテスト")
  @Nested
  public class DollarTest {

    @DisplayName("$5の2倍は$10であり、$5の3倍は$15である")
    @Test
    public void testMultiplication() {
      // arrange
      final Money fiveDollar = Money.dollar(5);

      // action
      // assert
      assertEquals(Money.dollar(10), fiveDollar.times(2));
      assertEquals(Money.dollar(15), fiveDollar.times(3));
    }

    @DisplayName("同じamountのときはequalsメソッドはtrueを返す")
    @Test
    public void testEquality() {
      // arrange
      final Money dollar1 = Money.dollar(5);
      final Money dollar2 = Money.dollar(5);

      // action
      // assert
      assertTrue(dollar1.equals(dollar2));
    }

    @DisplayName("違うamountのときはequalsメソッドはtrueを返す")
    @Test
    public void testEquality2() {
      // arrange
      final Money dollar1 = Money.dollar(5);
      final Money dollar2 = Money.dollar(6);

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
      final Money five = Money.franc(5);

      // action
      // assert
      assertEquals(Money.franc(10), five.times(2));
      assertEquals(Money.franc(15), five.times(3));
    }

    @DisplayName("同じamountのときはequalsメソッドはtrueを返す")
    @Test
    public void testEquality() {
      // arrange
      final Money franc1 = Money.franc(5);
      final Money franc2 = Money.franc(5);

      // action
      // assert
      assertTrue(franc1.equals(franc2));
    }

    @DisplayName("違うamountのときはequalsメソッドはfalseを返す")
    @Test
    public void testEquality2() {
      // arrange
      final Money franc1 = Money.franc(5);
      final Money franc2 = Money.franc(6);

      // action
      // assert
      assertFalse(franc1.equals(franc2));
    }

  }
}
