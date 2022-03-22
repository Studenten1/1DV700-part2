package startboatclub;

/**
 * This is the Sailboat class.
 */
public class Sailboat extends Boat {
  private String type = "sailboat";
  private int depth = 0;

  /**
   * The constructor.
   */
  public Sailboat(String theName, int theLength, int theDepth) {
    super(theName, theLength);
    setDepth(theDepth);
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

  @Override
  public String getText() {
    String text = "BOAT:" + super.getName() + ":" + this.getType() + ":" + super.getLength() + ":" + this.getDepth();
    return text;
  }

  @Override
  public String getBoatInfo() {
    String text = "Name: " + super.getName() + "\nType: " + this.getType() + "\nLength: " + super.getLength()
        + "\nDepth: " + this.getDepth();
    return text;
  }
}
