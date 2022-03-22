package startboatclub;

/**
 * This is the Canoe class.
 */
public class Canoe extends Boat {
  private String type = "canoe";

  /**
   * The constructor.
   */
  public Canoe(String theName, int theLength) {
    super(theName, theLength);
  }

  /**
   * Gets the type of the boat.
   *
   * @return type - (string)
   */
  public String getType() {
    return type;
  }

  @Override
  public String getText() {
    String text = "BOAT:" + super.getName() + ":" + this.getType() + ":" + super.getLength();
    return text;
  }

  @Override
  public String getBoatInfo() {
    String text = "Name: " + super.getName() + "\nType: " + this.getType() + "\nLength: " + super.getLength();
    return text;
  }
}
