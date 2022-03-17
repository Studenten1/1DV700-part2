package Boatclub;

import java.util.Scanner;

/**
 * This is the Boat Club App.
 */
public class App {
  /**
   * The App starting point.
   *
   * @param args Unused program arguments.
   */
  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in, "utf-8");
      Menu theMenu = new Menu();
      int end = theMenu.present(scan);
      if (end == 0) {
        scan.close();
      }
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
