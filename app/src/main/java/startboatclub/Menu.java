package startboatclub;

import java.util.Scanner;

/**
 * This is the Menu class.
 */
public class Menu {
  /**
   * Prints the start menu and handles the input.
   *
   * @param scan    - (object)
   * @param theList - (object)
   */
  public void present(Scanner scan, List theList) {
    System.out
        .print("\nWelcome to our Boat Club! Select one of the following options for editing our list of members:");
    System.out.print("\n1. Create a new member\n2. List the members");
    System.out.print("\n0. Quit the application\nWrite your choice here(0-2): ");

    int userInput = scan.nextInt();
    scan.nextLine();
    switch (userInput) {
      case 1:
        this.create(scan, theList);
        this.present(scan, theList);
        break;
      case 2:
        Member selectedMember = theList.printListOfMembers(scan);
        if (selectedMember == null) {
          this.present(scan, theList);
        } else {
          this.printMenu(scan, theList, selectedMember);
          this.present(scan, theList);
        }
        break;
      case 0:
        theList.save();
        break;
      default:
        System.out.println("Write a valid number!");
        this.present(scan, theList);
    }
  }

  /**
   * Handles the options for creating a new member.
   *
   * @param scan    - (object)
   * @param theList - (object)
   */
  public void create(Scanner scan, List theList) {
    System.out.print("\n Enter the member's name: ");
    String name = scan.nextLine();

    System.out.print("\n Enter the member's email(optional, enter q to skip this part): ");
    String email = scan.nextLine();
    if (email.equals("q") || email.equals("Q")) {
      Member createMember = new Member(name);
      theList.addMember(createMember);
    } else {
      // Checks if the email is unique.
      if (theList.checkEmail(email) == true) {
        Member createMember = new Member(name, email);
        theList.addMember(createMember);
      } else {
        System.out.println("This email is already registered! Try again");
      }
    }
  }

  /**
   * Prints another menu and handles the input.
   *
   * @param scan     - (object)
   * @param theList  - (object)
   * @param selected - (object)
   */
  public void printMenu(Scanner scan, List theList, Member selected) {
    System.out.print("\nYour choices:\n1. Delete the member. \n2. Add a new boat to the member.");
    System.out.print("\n3. Select a boat and se the detailed info about the boat.");
    System.out.print("\nEnter your choice as a number(use 0 to return to the main menu): ");
    int choice = scan.nextInt();
    scan.nextLine();
    switch (choice) {
      case 1:
        theList.deleteMember(selected);
        break;
      case 2:
        selected.addNewBoat(scan);
        break;
      case 3:
        Boat selectedBoat = selected.printListOfBoats(scan, selected);
        this.options(scan, selected, selectedBoat);
        break;
      case 0:
        break;
      default:
        System.out.println("Write a valid number!");
    }
  }

  /**
   * Handles the options for a boat.
   *
   * @param scan      - (object)
   * @param theMember - (object)
   * @param theBoat   - (object)
   */
  public void options(Scanner scan, Member theMember, Boat theBoat) {
    if (theBoat != null) {
      System.out.print(
          "\nYour choices:\n1. Delete the boat.\nEnter your choice as a number(use 0 to return to the main menu): ");
      int choice = scan.nextInt();
      scan.nextLine();
      if (choice == 1) {
        theMember.deleteBoat(theBoat);
      }
    }
  }
}
