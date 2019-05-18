package mahaker.tdd.bank;

import mahaker.tdd.money.Expression;
import mahaker.tdd.money.Money;

public class Bank {
  public Money reduce(Expression source, String toCurrency) {
    return source.reduce(toCurrency);
  }

}
