/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the App.
 */
public class App {

  /**
   * The App starting point.
   *
   * @param args Unused program arguments.
   */
  public static void main(String[] args) {
    try {
      // Present the menu.
      Scanner scan = new Scanner(System.in, "utf-8");
      Menu theMenu = new Menu();
      theMenu.start(scan);
      /* 
      HashTests tests = new HashTests();
      ArrayList<Integer> values = tests.getUniformityTestArray();
      System.out.println("The result is: " + tests.getUniformityDistributionResult(values, 4000));

      ArrayList<Integer> arrayOfValues = tests.getUniformityTestArrayForSimilarInput();
      System.out.println("The result (this time for similiar input strings) is: " + tests.getUniformityDistributionResult(arrayOfValues, 1200));

      //Test that the hash function is not a secure hash function.
      tests.printInputStringsAndHashValues();
      */
      scan.close();
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    } catch (Error error) {
      System.out.println("Error: " + error.getMessage());
      error.printStackTrace();
    }
  }
}
