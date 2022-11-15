package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Substitution {
  protected final String SECRET_KEY;
  private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private StringBuilder plainText = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
  private StringBuilder cipherText;
  private String textPath = "./src/main/java/assignment1/";
  String encryptedText = "";
  String myName = "Linda Meyer";


  /**
   * The constructor.
   */
  public Substitution(String theKey, String theText) {
    SECRET_KEY = theKey.toLowerCase();
    textPath = textPath.concat(theText);
    setCipherText();
  }

  /**
   * Sets the ciphertext.
   *
   */
  public void setCipherText() {
    cipherText = new StringBuilder();
    for (int a = 0; a < SECRET_KEY.length(); a++) {
        cipherText.append(SECRET_KEY.charAt(a));
        int count = 0;
        for (int i = 0; i < cipherText.length(); i++) {
            if (cipherText.charAt(i) == SECRET_KEY.charAt(a)) {
                count++;
            }
        }
        
        if (count == 2) {
            cipherText.deleteCharAt(cipherText.length() - 1);
        }
    }

    for (int b = 0; b < cipherText.length(); b++) {
        for (int c = 0; c < plainText.length(); c++) {
            if (plainText.charAt(c) == cipherText.charAt(b)) {
                plainText.deleteCharAt(c);
            }
        }
    }
    cipherText.append(plainText);
  }

  /**
   * Gets the name of the boat.
   *
   * @return name - (string)
   */
  public String getEncryptedText() {
    try {
      File file = new File(textPath);
      Scanner scanner = new Scanner(file, "utf-8");
      while (scanner.hasNext()) {
        String str = scanner.nextLine();
        encryptedText += (getEncryption(str) + "\n    ");
      }
      encryptedText += ("\n    " + getEncryption(myName) + "\n");
      scanner.close();
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
    return encryptedText;
  }

  /**
   * Gets the name of the boat.
   *
   * @return name - (string)
   */
  public void decryptText() {
    
  }

  /**
   * Gets the name of the boat.
   *
   * @return name - (string)
   */
  public String getEncryption(String str) {
    String encryptedText = "";
    System.out.print(str.charAt(0));
    for (int a = 0; a < str.length(); a++) {
      char character = str.charAt(a);
      String letter = String.valueOf(character);
      if (str.charAt(a) == ' ') {
        encryptedText += " ";
      } else if (str.charAt(a) == '?' || str.charAt(a) == '!' || str.charAt(a) == ',' || str.charAt(a) == '.') {
        encryptedText += str.charAt(a);
      } else if (alphabet.indexOf(letter.toLowerCase()) == -1) {
        encryptedText += str.charAt(a);
      } else {
        int index = alphabet.indexOf(letter.toLowerCase());
        char lowerCaseLetter = cipherText.charAt(index);
        if (alphabet.indexOf(letter) == -1) {
          encryptedText += String.valueOf(lowerCaseLetter).toUpperCase();
        } else {
          encryptedText += lowerCaseLetter;
        }
      }
    }
    return encryptedText;
  }
}
