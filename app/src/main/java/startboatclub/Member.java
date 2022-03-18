package startboatclub;

import java.util.ArrayList;

/**
 * This is the Member class.
 */
public class Member {
  private String name;
  private String email;
  private String memberId;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
   * The constructor.
   */
  public Member(String theName) {
    setName(theName);
  }

  /**
   * The constructor.
   */
  public Member(String theName, String theEmail) {
    setName(theName);
    setEmail(theEmail);
  }

  /**
   * Sets the name of the member.
   *
   * @param theName - (string)
   */
  public void setName(String theName) {
    name = theName;
  }

  /**
   * Gets the name of the member.
   *
   * @return name - (string)
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the email of the member.
   *
   * @param theEmail - (string)
   */
  public void setEmail(String theEmail) {
    email = theEmail;
  }

  /**
   * Gets the email of the member.
   *
   * @return email - (string)
   */
  public String getEmail() {
    return email;
  }

  /**
   * Adds the id of the member.
   *
   * @param theId - (string)
   */
  public void addId(String theId) {
    memberId = theId;
  }

  /**
   * Gets the id of the member.
   *
   * @return memberId - (string)
   */
  public String getId() {
    return memberId;
  }

  /**
   * Adds a boat to a member.
   *
   * @param theBoat - (object)
   */
  public void addBoat(Boat theBoat) {
    boats.add(theBoat);
  }

  /**
   * Gets the info text about boats of a member.
   *
   * @return text - (string)
   */
  public String getBoatsText() {
    String text = "";
    for (int a = 0; a < boats.size(); a++) {
      text = boats.get(a).getText();
      text += "\n";
    }
    return text;
  }

  /**
   * Gets the info text of the member.
   *
   * @return text - (string)
   */
  public String getText() {
    if (this.getEmail() == null) {
      String text = "MEMBER:" + this.getName() + ":" + this.getId();
      return text;
    } else {
      String text = "MEMBER:" + this.getName() + ":" + this.getEmail() + ":" + this.getId();
      return text;
    }
  }
}
