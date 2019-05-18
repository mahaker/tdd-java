package mahaker.tdd.money;

public class Money {
  protected int amount;

  @Override
  public boolean equals(Object o) {
    final Money money = (Money) o;
    return this.amount == money.amount;
  }
}
