package mahaker.tdd.money;

public class Dollar {
  private int amount;

  public Dollar(int amount) {
    this.amount = amount;
  }

  public Dollar times(int multiplier) {
    return new Dollar(this.amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    if ( !(o instanceof Dollar) ) return false;

    final Dollar dollar = (Dollar) o;
    return this.amount == dollar.amount;
  }
}
