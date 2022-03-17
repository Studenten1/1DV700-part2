package Boatclub;

/**
 * This is the Boat class.
 */
public class Boat {
  private String name;
  private String type;
  private int length;
  private int depth;
  private int power;

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
   * Sets the type of the boat.
   *
   * @param theType - (string)
   */
  public void setType(String theType) {
    type = theType;
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
}
