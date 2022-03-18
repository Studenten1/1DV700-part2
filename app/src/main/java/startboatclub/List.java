package startboatclub;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * This is the List class.
 */
public class List {
  private StringBuilder text = new StringBuilder();
  private Member currentMember;
  private ArrayList<Member> members = new ArrayList<>();

  /**
   * Loads the data and converts it to a list of objects.
   *
   */
  public void load() {
    try {
      File file = new File("\\registry.data");
      Scanner scanner = new Scanner(file, "utf-8");

      while (scanner.hasNext()) {
        String str = scanner.nextLine();
        String[] array = str.split(":");
        // If the text string starts with the word Member.
        if (array[0].equals("MEMBER")) {
          if (array.length == 3) {
            String name = array[1];
            String id = array[2];
            currentMember = new Member(name);
            currentMember.addId(id);
            members.add(currentMember);
          } else {
            String name = array[1];
            String email = array[2];
            String id = array[3];
            currentMember = new Member(name, email);
            currentMember.addId(id);
            members.add(currentMember);
          }
          // If the text string starts with the word Boat.
        } else if (array[0].equals("BOAT")) {
          if (array.length == 4) {
            String name = array[1];
            String type = array[2];
            String length = array[3];
            int theLength = Integer.parseInt(length);
            Boat thisBoat = new Boat(name, type, theLength);
            currentMember.addBoat(thisBoat);
          } else if (array.length == 5) {
            String name = array[1];
            String type = array[2];
            String length = array[3];
            int optionOne = Integer.parseInt(array[4]);
            int theLength = Integer.parseInt(length);
            Boat thisBoat = new Boat(name, type, theLength, optionOne);
            currentMember.addBoat(thisBoat);
          } else if (array.length == 6) {
            String name = array[1];
            String type = array[2];
            String length = array[3];
            int optionOne = Integer.parseInt(array[4]);
            int optionTwo = Integer.parseInt(array[5]);
            int theLength = Integer.parseInt(length);
            Boat thisBoat = new Boat(name, type, theLength, optionOne, optionTwo);
            currentMember.addBoat(thisBoat);
          }
        }
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Overwrites the data and saves the file.
   *
   */
  public void save() {
    try {
      int arrayLength = members.size();
      for (int i = 0; i < arrayLength; i++) {
        currentMember = members.get(i);
        String str = currentMember.getText();
        text.append(str + "\n");
        text.append(currentMember.getBoatsText());
      }
      File outFile = new File("\\registry.data");
      PrintWriter printer = new PrintWriter(outFile, "utf-8");
      printer.print(text);
      printer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a unique id and adds a new member to the list.
   *
   * @param newMember (object)
   */
  public void addMember(Member newMember) {
    UUID random = UUID.randomUUID();
    String id = random.toString();
    for (Member m : members) {
      String otherId = m.getId();
      if (id.equals(otherId)) {
        this.addMember(newMember);
      } else {
        newMember.addId(id);
        members.add(newMember);
      }
    }
  }

  /**
   * Checks if the submitted email is unique.
   *
   * @param theEmail (string)
   * @return (boolean)
   */
  public boolean checkEmail(String theEmail) {
    for (Member m : members) {
      String email = m.getEmail();
      if (theEmail.equals(email)) {
        return false;
      }
    }
    return true;
  }
}
