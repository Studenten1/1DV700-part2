package startboatclub;

public class Motorboat extends Boat {
  private String type = "motorboat";
  private int power = 0;

  /**
   * The constructor.
   */
  public Motorboat(String theName, int theLength, int thePower) {
    super(theName, theLength);
    setPower(thePower);
  }

  /**
   * Gets the type of the boat.
   *
   * @return type - (string)
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the power of the boat.
   *
   * @return power - (int)
   */
  public int getPower() {
    return power;
  }

  /**
   * Sets the power of the boat.
   *
   * @param thePower - (int)
   */
  public void setPower(int thePower) {
    power = thePower;
  }

  @Override
  public String getText() {
    String text = "BOAT:" + super.getName() + ":" + this.getType() + ":" + super.getLength() + ":" + this.getPower();
    return text;
  }
}
