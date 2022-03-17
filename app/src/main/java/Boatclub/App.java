package Boatclub;

import java.io.IOException;
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
      theMenu.present(scan);

      scan.close();
    } catch (IOException e) {
      System.out.println("IO Exception: " + e.getMessage());
    } catch (Exception error) {
      System.out.println("Exception: " + error.getMessage());
    }
  }
}
