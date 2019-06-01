package mahaker.tdd.money;

import mahaker.tdd.bank.Bank;
import mahaker.tdd.bank.Sum;
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
      final Money reduced = bank.reduce(sum, "USD");
      assertEquals(Money.dollar(10), reduced);
    }

    @DisplayName("Bank#reduceを実行すると結果を得られること")
    @Test
    public void testReduceSum() {
      // arrange
      final Money augendDollar = Money.dollar(5);
      final Money addendDollar = Money.dollar(6);
      final Expression sum = new Sum(augendDollar, addendDollar);

      // action
      final Bank bank = new Bank();
      final Money result = bank.reduce(sum, "USD");

      // assert
      assertEquals(Money.dollar(11), result);
    }

    @DisplayName("Bank#reduceにMoneyを渡せること")
    @Test
    public void testReduceMoney() {
      // arrange
      final Bank bank = new Bank();

      // action
      final Money result = bank.reduce(Money.dollar(1), "USD");

      // assert
      assertEquals(Money.dollar(1), result);
    }

    @DisplayName("plusメソッドの結果はSumクラスであること")
    @Test
    public void testAdditionReturnsSum() {
      final Money five = Money.dollar(5);
      Expression result = five.plus(five);
      final Sum sum = (Sum) result;
      assertEquals(five, sum.augend);
      assertEquals(five, sum.addend);
    }

    @DisplayName("異なる通貨同士の足し算")
    @Test
    public void testReduceMoneyDifferentMoney() {
      // arrange
      final Bank bank = new Bank();
      bank.addRate("CHF", "USD", 2);

      // action
      final Money result = bank.reduce(Money.franc(2), "USD");

      // assert
      assertEquals(Money.dollar(1), result);
    }

    @DisplayName("異なる通貨同士の足し算ができること")
    @Test
    public void testMixedAddition() {
      // arrange
      final Expression fiveDollars = Money.dollar(5);
      final Expression tenFrancs = Money.franc(10);
      final Bank bank = new Bank();
      bank.addRate("CHF", "USD", 2);

      // action
      final Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");

      // assert
      assertEquals(Money.dollar(10), result);
    }

    @DisplayName("同じ通貨の場合はrateは1になること")
    @Test
    public void testIdentityRate() {
      // arrange
      // action

      // assert
      assertEquals(1, new Bank().rate("USD", "USD"));
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
