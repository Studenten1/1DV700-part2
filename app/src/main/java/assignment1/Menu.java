package assignment1;

import java.util.Scanner;

public class Menu {
  private HashFunction newHashFunction;

  public Menu () {
    newHashFunction = new HashFunction();
  }

  /**
   * Prints the start menu and handles the input.
   *
   * @param scan    - (object)
   * @param theList - (object)
   */
  public void start(Scanner scan) {
    System.out
        .print("\nThis is a hash function: ");
    System.out.print("\nPlease submit the input: ");

    String input = scan.nextLine();
    int hashCode = newHashFunction.getHashCode(input);
    System.out.println(hashCode);
  }
}
