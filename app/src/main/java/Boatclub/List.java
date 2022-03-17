package Boatclub;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the List class.
 */
public class List {
  StringBuilder text = new StringBuilder();
  ArrayList<Member> members = new ArrayList<>();

  /**
   * Loads the data and converts it to a list of objects.
   *
   * @param scan (object)
   * @return (int)
   */
  public void load() {
    try { 
      File file = new File("/registry.data");
      Scanner scanner = new Scanner(file); 
      while (scanner.hasNext()) {
        String str = scanner.nextLine (); 
        text.append(str + "\n"); 
      }
      scanner.close ();
    } catch (IOException e) { e. printStackTrace (); }
  }

  /**
   * Overwrites the data and saves the file.
   *
   * @param scan (object)
   * @return (int)
   */
  public void save() {
    try { 
      File outFile = new File("/registry.data");
      PrintWriter printer = new PrintWriter(outFile);
      printer.print(text); 
      printer.close();
    } catch (IOException e) { e. printStackTrace (); }
  }
}
