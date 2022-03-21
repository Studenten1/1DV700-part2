package startboatclub;

import java.util.ArrayList;
import java.util.Scanner;

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
    if (theId.length() != 6) {
      System.out.println("The submitted ID does not contain six characters! Try again");
    }
    String thisId = theId.toLowerCase();
    memberId = thisId;
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
   * Asks for info and then adds the new boat to the member.
   *
   * @param scan - (object)
   */
  public void addNewBoat(Scanner scan) {
    System.out.print("\nEnter the name of the boat: ");
    String name = scan.nextLine();
    System.out.print("\nEnter the type of the boat: ");
    String type = scan.nextLine();
    System.out.print("\nEnter the length of the boat: ");
    int length = scan.nextInt();
    scan.nextLine();
    System.out.print("\nEnter the depth of the boat(optional, enter 0 to skip): ");
    final int depth = scan.nextInt();
    scan.nextLine();
    System.out.print("\nEnter the power of the boat(optional, enter 0 to skip): ");
    int power = scan.nextInt();
    scan.nextLine();

    if (depth == 0 && power == 0) {
      Boat newBoat = new Boat(name, type, length);
      boats.add(newBoat);
      System.out.println("\nThe new boat is added successfully");
    } else if (depth == 0) {
      Boat newBoat = new Boat(name, type, length, power);
      boats.add(newBoat);
      System.out.println("\nThe new boat is added successfully");
    } else if (power == 0) {
      Boat newBoat = new Boat(name, type, length, depth);
      boats.add(newBoat);
      System.out.println("\nThe new boat is added successfully");
    } else {
      Boat newBoat = new Boat(name, type, length, depth, power);
      boats.add(newBoat);
      System.out.println("\nThe new boat is added successfully");
    }
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

  /**
   * Prints a list of the boats and returns the selected boat.
   *
   * @return thisMember - (object)
   */
  public Boat printListOfBoats(Scanner scan) {
    int number = 1;
    for (Boat b : boats) {
      System.out.println(number + ". " + b.getName());
      number++;
    }

    System.out.print("\nSelect a particular boat? Enter its number(enter 0 to return to the main menu): ");
    int choice = scan.nextInt();
    scan.nextLine();
    int nrOfElements = boats.size();
    if (choice == 0) {
      return null;
    } else if (1 <= choice && choice <= nrOfElements) {
      Boat thisBoat = boats.get((choice - 1));
      System.out.println("\nName: " + thisBoat.getName() + "\nType: " + thisBoat.getType() + "\nLength: "
          + thisBoat.getLength() + "\nDepth: " + thisBoat.getDepth() + "\nPower: " + thisBoat.getPower());
      return thisBoat;
    } else {
      System.out.println("\nError! Enter a valid number!");
      return null;
    }
  }

  /**
   * Deletes a boat.
   *
   * @param boat - (object)
   */
  public void deleteBoat(Boat boat) {
    boolean answer = boats.remove(boat);
    if (answer) {
      System.out.println("\nThe selected boat is deleted successfully");
    } else {
      System.out.println("\nError! Failed to delete boat.");
    }
  }
}
