package mahaker.tdd.bank;

import mahaker.tdd.money.Expression;
import mahaker.tdd.money.Money;

public class Sum implements Expression {
  public Expression augend;
  public Expression addend;

  public Sum(Expression augend, Expression addend) {
    this.augend = augend;
    this.addend = addend;
  }

  @Override
  public Money reduce(Bank bank, String toCurrency) {
    final int amount
      = this.augend.reduce(bank, toCurrency).getAmount() + this.addend.reduce(bank, toCurrency).getAmount();
    return new Money(amount, toCurrency);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  public Expression times(int multiplier) {
    return new Sum(this.augend.times(multiplier), this.addend.times(multiplier));
  }
}
