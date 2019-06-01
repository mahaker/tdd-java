package mahaker.tdd.bank;

import mahaker.tdd.money.Expression;
import mahaker.tdd.money.Money;

public class Sum implements Expression {
  public Money augend;
  public Money addend;

  public Sum(Money augend, Money addend) {
    this.augend = augend;
    this.addend = addend;
  }

  @Override
  public Money reduce(Bank bank, String toCurrency) {
    return new Money(this.augend.getAmount() + this.addend.getAmount(), toCurrency);
  }
}
