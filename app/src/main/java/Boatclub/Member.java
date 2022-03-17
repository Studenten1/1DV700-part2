package Boatclub;

import java.util.ArrayList;

/**
 * This is the Member class.
 */
public class Member {
  private String name;
  private String email;
  private String memberId;
  ArrayList<Boat> boats = new ArrayList<>();

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
   * Sets the email of the member.
   *
   * @param theEmail - (string)
   */
  public void setEmail(String theEmail) {
    email = theEmail;
  }
}
