package startboatclub;

/**
 * This is the Boat class.
 */
public abstract class Boat {
  private String name;
  private int length = 0;

  /**
   * The constructor.
   */
  public Boat(String theName, int theLength) {
    setName(theName);
    setLength(theLength);
  }

  /**
   * Sets the name of the boat.
   *
   * @param theName - (string)
   */
  public void setName(String theName) {
    name = theName;
  }

  /**
   * Gets the name of the boat.
   *
   * @return name - (string)
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets the length of the boat.
   *
   * @param theLength - (int)
   */
  public void setLength(int theLength) {
    length = theLength;
  }

  /**
   * Gets the length of the boat.
   *
   * @return length - (int)
   */
  public int getLength() {
    return length;
  }

  public abstract String getText();
}
