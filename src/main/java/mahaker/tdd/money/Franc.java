package mahaker.tdd.money;

public class Franc {
  private int amount;

  public Franc(int amount) {
    this.amount = amount;
  }

  public Franc times(int multiplier) {
    return new Franc(this.amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    if ( !(o instanceof Franc) ) return false;

    final Franc franc = (Franc) o;
    return this.amount == franc.amount;
  }
}
