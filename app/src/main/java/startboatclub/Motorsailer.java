package startboatclub;

public class Motorsailer extends Boat {
  private String type = "motorsailer";
  private int depth = 0;
  private int power = 0;

  /**
   * The constructor.
   */
  public Motorsailer(String theName, int theLength, int theDepth, int thePower) {
    super(theName, theLength);
    setDepth(theDepth);
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
   * Gets the depth of the boat.
   *
   * @return depth - (int)
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Sets the depth of the boat.
   *
   * @param theDepth - (int)
   */
  public void setDepth(int theDepth) {
    depth = theDepth;
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
    String text = "BOAT:" + super.getName() + ":" + this.getType() + ":" + super.getLength() + ":" + this.getDepth() + ":" + this.getPower();
    return text;
  }
}
