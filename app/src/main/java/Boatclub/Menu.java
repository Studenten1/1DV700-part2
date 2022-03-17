package Boatclub;

import java.util.Scanner;

/**
 * This is the Menu class.
 */
public class Menu {
  /**
   * Prints the menu and handles the input.
   *
   * @param scan (object)
   * @return (int)
   */
  public int present (Scanner scan) {
    System.out.print("Welcome to our Boat Club! Select one of the following options for editing our list of members:\n1. Add a new member\n2. List the members  \n3. Select a particular member\n0. Quit the application\nWrite your choice here(0-3): ");

    List theList = new List();
    theList.load();

    int userInput = scan.nextInt();
    switch (userInput) {
        case 1:
          System.out.println("Score: " + result[0] + " (you) " + result[1] + " (computer) " + result[2] + " (draw).\n");
          a = 2000;
          this.present(scan);
          break;
        case 2:
          computerNumber = rnd.nextInt(3) + 1;
          writeResult(youNumber, computerNumber, result);
          this.present(scan);
          break;
        case 3:
          computerNumber = rnd.nextInt(3) + 1;
          writeResult(youNumber, computerNumber, result);
          this.present(scan);
          break;
        case 0:
          theList.save();
          return 0;
          break;
        default:
          System.out.println("Write a valid number!");
          this.present(scan);
      }
  }
}
