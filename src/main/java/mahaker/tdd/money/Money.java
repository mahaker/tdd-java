package mahaker.tdd.money;

import mahaker.tdd.bank.Bank;
import mahaker.tdd.bank.Sum;

public class Money implements Expression {
  protected int amount;
  protected String currency;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  public String currency() {
    return currency;
  }

  public Expression plus(Money addend) {
    return new Sum(this, addend);
  }

  public int getAmount() {
    return this.amount;
  }

  @Override
  public Money reduce(Bank bank, String toCurrency) {
    final int rate = bank.rate(this.currency, toCurrency);
    return new Money(this.amount / rate, toCurrency);
  }

  /**
   * Dollarクラスを返すFactory Method
   * @param amount
   * @return Money
   */
  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  /**
   * Francクラスを返すFactory Method
   * @param amount
   * @return Money
   */
  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  @Override
  public boolean equals(Object o) {
    final Money money = (Money) o;

    return this.amount == money.amount
      && currency().equals(((Money) o).currency());
  }

  @Override
  public String toString() {
    return amount + " " + currency();
  }
}
