package startboatclub;

import java.util.Scanner;

/**
 * This is the Menu class.
 */
public class Menu {
  /**
   * Prints the menu and handles the input.
   *
   * @param scan    (object)
   * @param theList (object)
   */
  public void present(Scanner scan, List theList) {
    System.out.print("Welcome to our Boat Club! Select one of the following options for editing our list of members:");
    System.out.print("\n1. Create a new member\n2. List the members");
    System.out.print("\n3. Select a particular member\n0. Quit the application\nWrite your choice here(0-3): ");

    int userInput = scan.nextInt();
    scan.nextLine();
    switch (userInput) {
      case 1:
        this.create(scan, theList);
        this.present(scan, theList);
        break;
      case 2:

        break;
      case 3:

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
   * @param scan    (object)
   * @param theList (object)
   */
  public void create(Scanner scan, List theList) {
    System.out.print("\n Enter your name: ");
    String name = scan.nextLine();

    System.out.print("\n Enter your email(optional, enter q to skip this part): ");
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
}
