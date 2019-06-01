package mahaker.tdd.money;

import mahaker.tdd.bank.Bank;

public interface Expression {

  Money reduce(Bank bank, String toCurrency);
}
