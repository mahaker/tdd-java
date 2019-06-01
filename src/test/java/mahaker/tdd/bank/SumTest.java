package mahaker.tdd.bank;

import mahaker.tdd.money.Expression;
import mahaker.tdd.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

  @DisplayName("Sum.plusメソッドのテスト")
  @Test
  public void testSumPlusMoney() {
    // arrange
    final Expression fiveBacks = Money.dollar(5);
    final Expression tenFrancs = Money.franc(10);
    final Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    final Expression sum = new Sum(fiveBacks, tenFrancs).plus(fiveBacks);

    // action
    final Money result = bank.reduce(sum, "USD");

    // assert
    assertEquals(Money.dollar(15), result);
  }

  @DisplayName("Sum.timesメソッドのテスト")
  @Test
  public void testSumTimes() {
    // arrange
    final Expression fiveBacks = Money.dollar(5);
    final Expression tenFrancs = Money.franc(10);
    final Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    final Expression sum = new Sum(fiveBacks, tenFrancs).times(2);

    // action
    final Money result = bank.reduce(sum, "USD");

    // assert
    assertEquals(Money.dollar(20), result);
  }
}