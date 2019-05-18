package mahaker.tdd.money;

public abstract class Money {
  protected int amount;

  // TODO まだ実装はサブクラスにある
  public abstract Money times(int amount);

  /**
   * Dollarクラスを返すFactory Method
   * @param amount
   * @return Money
   */
  public static Money dollar(int amount) {
    return new Dollar(amount);
  }

  /**
   * Francクラスを返すFactory Method
   * @param amount
   * @return Money
   */
  public static Money franc(int amount) {
    return new Franc(amount);
  }

  @Override
  public boolean equals(Object o) {
    final Money money = (Money) o;

    // TODO モデルにJavaの仕組みが出てくるのはなぜ？
    return this.amount == money.amount
      && getClass() == o.getClass();
  }
}
