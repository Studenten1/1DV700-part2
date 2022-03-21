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
  private String path = "C:\\Users\\meyer\\Documents\\1DV502\\assignment-4\\app\\src\\main\\java\\startboatclub\\registry.data";

  /**
   * Loads the data and converts it to a list of objects.
   *
   */
  public void load() {
    try {
      File file = new File(path);
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
      File outFile = new File(path);
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
    String first = random.toString();
    String id = first.substring(0, 6);
    for (Member m : members) {
      String otherId = m.getId();
      while (id.equals(otherId)) {
        random = UUID.randomUUID();
        first = random.toString();
        id = first.substring(0, 6);
      }
    }
    newMember.addId(id);
    members.add(newMember);
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

  /**
   * Prints a list of the members and returns the selected member.
   *
   * @return thisMember - (object)
   */
  public Member printListOfMembers(Scanner scan) {
    int number = 1;
    for (Member m : members) {
      System.out.println(number + ". " + m.getName());
      number++;
    }

    System.out.print("\nSelect a particular member? Enter their number(enter 0 to return to the main menu): ");
    int choice = scan.nextInt();
    scan.nextLine();
    int nrOfElements = members.size();
    if (choice == 0) {
      return null;
    } else if (1 <= choice && choice <= nrOfElements) {
      Member thisMember = members.get((choice - 1));
      System.out.println(
          "\nName: " + thisMember.getName() + "\nEmail: " + thisMember.getEmail() + "\nID: " + thisMember.getId());
      return thisMember;
    } else {
      System.out.println("\nError! Enter a valid number!");
      return null;
    }
  }

  /**
   * Deletes a member.
   *
   * @param member - (object)
   */
  public void deleteMember(Member member) {
    boolean answer = members.remove(member);
    if (answer) {
      System.out.println("\nThe selected member is deleted successfully");
    } else {
      System.out.println("\nError! Failed to delete member.");
    }
  }
}
