package mahaker.tdd.money;

public class Money {
  protected int amount;

  @Override
  public boolean equals(Object o) {
    final Money money = (Money) o;

    // TODO モデルにJavaの仕組みが出てくるのはなぜ？
    return this.amount == money.amount
      && getClass() == o.getClass();
  }
}
