package mahaker.tdd.bank;

import mahaker.tdd.money.Expression;
import mahaker.tdd.money.Money;
import mahaker.tdd.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class Bank {
  private final Map<Pair, Integer> rates = new HashMap<>();

  public Money reduce(Expression source, String toCurrency) {
    return source.reduce(this, toCurrency);
  }

  public void addRate(String from, String to, int rate) {
    rates.put(new Pair(from, to), rate);
  }

  public int rate(String from, String to) {
    if(from.equals(to)) return 1;
    return rates.get(new Pair(from, to));
  }
}
