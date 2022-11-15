package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
    private String lmPath = "./src/main/java/assignment1/lm222sp.txt";
    private String thePath = "./src/main/java/assignment1/encryptedMessageTransposition.txt";
    private StringBuilder text;

  /**
   * Prints the start menu and handles the input.
   *
   * @param scan    - (object)
   * @param theList - (object)
   */
  public void start(Scanner scan) {
    System.out
        .print("\nWelcome to the encryption/decryption program! Which encryption method would you like to use?");
    System.out.print("\n1. Substitution method\n2. Transposition method");
    System.out.print("\nWrite your choice here(1-2): ");

    int firstAnswer = scan.nextInt();
    scan.nextLine();

    System.out
        .print("\nDo you want to perform encryption or decryption?");
    System.out.print("\n1. Encryption\n2. Decryption");
    System.out.print("\nWrite your choice here(1-2): ");

    int secondAnswer = scan.nextInt();
    scan.nextLine();


    System.out.print("\nEnter your secret key(max 8 characters): ");
    String secretKey = scan.nextLine();
    while (secretKey.length() > 8 || secretKey.length() < 1) {
        System.out.print("\nEnter your secret key(max 8 characters): ");
        secretKey = scan.nextLine();
    }

    System.out.print("\nEnter the name of the text file to process (for example: message.txt): ");
    String name = scan.nextLine();
    
    if (firstAnswer == 1 && secondAnswer == 1) {
        Substitution method = new Substitution(secretKey, name);
        String encryptedText = method.getEncryptedText();
        saveEncryptedTextFile(encryptedText, lmPath);
        System.out.println("The path to the processed text file is " + lmPath);
    } else if (firstAnswer == 1 && secondAnswer == 2) {
        Substitution method = new Substitution(secretKey, name);
        String decryptedText = method.getDecryptedText();
        System.out.println("The decrypted message is:\n" + decryptedText);
    } else if (firstAnswer == 2 && secondAnswer == 2) {
        Transposition method = new Transposition(secretKey, name);
        String decryptedText = method.getDecryptedText();
        System.out.println("The decrypted message is:\n" + decryptedText);
    } else if (firstAnswer == 2 && secondAnswer == 1) {
        Transposition method = new Transposition(secretKey, name);
        String encryptedText = method.getEncryptedText();
        saveEncryptedTextFile(encryptedText, thePath);
        System.out.println("The path to the processed text file is " + thePath);
    } else {
        System.out.println("Write a valid number!");
        this.start(scan);
    }
  }

  

  /**
   * Overwrites the data and saves the file.
   *
   */
  public void saveEncryptedTextFile(String encryptedText, String path) {
    try {
      text = new StringBuilder();
      text.append("\n");
      File outFile = new File(path);
      PrintWriter printer = new PrintWriter(outFile, "utf-8");
      printer.println("***************************************************************************************************");
      printer.println("*                                                                                                 *");
      printer.println("*                                Secret message - Top Secret                                      *");
      printer.println("*                                                                                                 *");
      printer.println("*                      May only be read by security passed personnel                              *");
      printer.println("*                                                                                                 *");
      printer.println("***************************************************************************************************");
      printer.print("\n    " + encryptedText + "\n***************************************************************************************************");
      printer.close();
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Test decryption.
   *
   */
  public void testDecryption() {
    Substitution method = new Substitution("nc222hk.txt");
    String decryptedTextAttempts = method.getDecryptedTextsMethod();
    System.out.println(decryptedTextAttempts);
  }

}
