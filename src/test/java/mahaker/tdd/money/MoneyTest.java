package mahaker.tdd.money;

import mahaker.tdd.bank.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("moneyパッケージ内のクラスのテスト")
public class MoneyTest {

  @DisplayName("Moneyクラスのテスト")
  @Nested
  public class MoneyClassTest {

    @DisplayName("別の通貨同士を比較すると、falseを返すこと")
    @Test
    public void testEqualityOtherMonies() {
      // arrange
      final Money dollar = Money.dollar(5);
      final Money franc = Money.franc(5);

      // action
      // assert
      assertFalse(dollar.equals(franc));
    }

    @DisplayName("金額の掛け算が正しいこと")
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

    @DisplayName("通貨の足し算ができること")
    @Test
    public void testAddition() {
      final Money five = Money.dollar(5);
      Expression sum = five.plus(five);
      final Bank bank = new Bank();
      final Money reduced = bank.reduced(sum, "USD");
      assertEquals(Money.dollar(10), reduced);
    }

  }

  @DisplayName("currencyのテスト")
  @Nested
  public class CurrencyTest {

    @DisplayName("通貨情報を取得できること")
    @Test
    public void testCurrency() {
      // arrange
      // action
      // assert
      assertEquals("USD", Money.dollar(1).currency());
      assertEquals("CHF", Money.franc(1).currency());
    }

  }
}
