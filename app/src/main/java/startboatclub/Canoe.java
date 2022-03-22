package startboatclub;

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
}
