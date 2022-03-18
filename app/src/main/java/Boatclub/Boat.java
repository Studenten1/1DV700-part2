package Boatclub;

/**
 * This is the Boat class.
 */
public class Boat {
  private String name;
  private String type;
  private int length = 0;
  private int depth = 0;
  private int power = 0;

  /**
   * The constructor.
   */
  public Boat(String theName, String theType, int theLength) {
    setName(theName);
    setType(theType);
    setLength(theLength);
  }

  /**
   * The constructor.
   */
  public Boat(String theName, String theType, int theLength, int optionOne) {
    setName(theName);
    setType(theType);
    setLength(theLength);
    setOptionOne(optionOne);
  }

  /**
   * The constructor.
   */
  public Boat(String theName, String theType, int theLength, int optionOne, int optionTwo) {
    setName(theName);
    setType(theType);
    setLength(theLength);
    setOptionOne(optionOne);
    setOptionTwo(optionTwo);
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
   * Sets the type of the boat.
   *
   * @param theType - (string)
   */
  public void setType(String theType) {
    type = theType;
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

  /**
   * Gets the depth of the boat.
   *
   * @return depth - (int)
   */
  public int getDepth() {
    return depth;
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
   * Sets option one of the boat's information.
   *
   * @param optionOne - (int)
   */
  public void setOptionOne(int optionOne) {
    if (optionOne <= 10) {
      depth = optionOne;
    } else {
      power = optionOne;
    }
  }

  /**
   * Sets option two of the boat's information.
   *
   * @param optionTwo - (int)
   */
  public void setOptionTwo(int optionTwo) {
    power = optionTwo;
  }

   /**
   * Gets the info text of the boat.
   *
   * @return text - (string)
   */
  public String getText() {
    if (this.getDepth() == 0 && this.getPower() == 0) {
      String text = "BOAT:" + this.getName() + ":" + this.getType() + ":" + this.getLength();
      return text;
    } else if (this.getDepth() == 0) {
      String text = "BOAT:" + this.getName() + ":" + this.getType() + ":" + this.getLength() + ":" + this.getPower();
      return text;
    } else if (this.getPower() == 0) {
      String text = "BOAT:" + this.getName() + ":" + this.getType() + ":" + this.getLength() + ":" + this.getDepth();
      return text;
    } else {
      String text = "BOAT:" + this.getName() + ":" + this.getType() + ":" + this.getLength() + ":" + this.getDepth() + ":" + this.getPower();
      return text;
    }
  }
}
