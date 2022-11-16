package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Substitution {
  protected String SECRET_KEY;
  private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private StringBuilder plainText = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
  private StringBuilder cipherText;
  private String textPath = "./src/main/java/assignment1/";
  String encryptedText = "";
  String myName = "Linda Meyer";
  String decryptedText = "";

  /**
   * The constructor.
   */
  public Substitution(String theKey, String theTextFile) {
    SECRET_KEY = theKey.toLowerCase();
    textPath = textPath.concat(theTextFile);
    setCipherText();
  }

  /**
   * The other constructor, only for testing to decrypt a message without the key.
   */
  public Substitution(String theTextFile) {
    textPath = textPath.concat(theTextFile);
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
   * Returns the encrypted text as a string.
   *
   * @return encryptedText - (string)
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
   * Returns the decrypted text as a string.
   *
   * @return decryptedText - (string)
   */
  public String getDecryptedText() {
    try {
      File file = new File(textPath);
      Scanner scanner = new Scanner(file, "utf-8");
      while (scanner.hasNextLine()) {
        String str = scanner.nextLine();
        decryptedText += (getDecryption(str) + "\n    ");
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
    return decryptedText;
  }

  /**
   * Returns results of trying to decrypt a text.
   *
   * @return allAttempts - (string)
   */
  public String getDecryptedTextsMethod() {
    String allAttempts = "";
    try {
      File file = new File(textPath);
      Scanner scanner = new Scanner(file, "utf-8");
      for (int a = 0; a < 20; a++) {
        scanner = new Scanner(file, "utf-8");
        StringBuilder cipherTest = getCipher();
        String oneTestOfDecryption = "";
        oneTestOfDecryption += ("The following decryption attempt used the cipher " + cipherTest + "\n");

        while (scanner.hasNextLine()) {
          String str = scanner.nextLine();
          oneTestOfDecryption += (getDecryptionAttempt(cipherTest, str) + "\n    ");
        }

        allAttempts += (oneTestOfDecryption + "\n");
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
    return allAttempts;
  }

  /**
   * Returns one version of ciphertext alphabet.
   *
   * @return cipher - (string)
   */
  public StringBuilder getCipher() {
    StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    // My guess
    StringBuilder cipher = new StringBuilder("fcpevqkzg-trayon-jdlwhbxsi");
    // Random
    for (int a = 0; a < cipher.length(); a++) {
      if (cipher.charAt(a) != '-') {
        alphabet.deleteCharAt(alphabet.indexOf(String.valueOf(cipher.charAt(a))));
      }
    }

    for (int b = 0; b < cipher.length(); b++) {
      if (cipher.charAt(b) == '-') {
        int randomIndex = (int)(Math.random() * alphabet.length()) + 0;
        char character = alphabet.charAt(randomIndex);
        alphabet.deleteCharAt(randomIndex);
        cipher.setCharAt(b, character);
      }
    }
    return cipher;
  }

  /**
   * Handles the encryption.
   *
   * @return encryptedText - (string)
   */
  public String getEncryption(String str) {
    String encryptedText = "";
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

  /**
   * Handles the decryption.
   *
   * @return decryptedText - (string)
   */
  public String getDecryption(String str) {
    String decryptedText = "";
    for (int a = 0; a < str.length(); a++) {
      char character = str.charAt(a);
      String letter = String.valueOf(character);
      if (str.charAt(a) == ' ') {
        decryptedText += " ";
      } else if (str.charAt(a) == '?' || str.charAt(a) == '!' || str.charAt(a) == ',' || str.charAt(a) == '.') {
        decryptedText += str.charAt(a);
      } else if (alphabet.indexOf(letter.toLowerCase()) == -1) {
        decryptedText += str.charAt(a);
      } else {
        int index = cipherText.indexOf(letter.toLowerCase());
        char lowerCaseLetter = alphabet.charAt(index);
        if (cipherText.indexOf(letter) == -1) {
          decryptedText += String.valueOf(lowerCaseLetter).toUpperCase();
        } else {
          decryptedText += lowerCaseLetter;
        }
      }
    }
    return decryptedText;
  }

  /**
   * Handles the attempts of decryption.
   *
   * @return decryptedTextTry - (string)
   */
  public String getDecryptionAttempt(StringBuilder cipherTry, String str) {
    String decryptedText = "";
    for (int a = 0; a < str.length(); a++) {
      char character = str.charAt(a);
      String letter = String.valueOf(character);
      if (str.charAt(a) == ' ') {
        decryptedText += " ";
      } else if (str.charAt(a) == '?' || str.charAt(a) == '!' || str.charAt(a) == ',' || str.charAt(a) == '.') {
        decryptedText += str.charAt(a);
      } else if (alphabet.indexOf(letter.toLowerCase()) == -1) {
        decryptedText += str.charAt(a);
      } else {
        int index = cipherTry.indexOf(letter.toLowerCase());
        char lowerCaseLetter = alphabet.charAt(index);
        if (cipherTry.indexOf(letter) == -1) {
          decryptedText += String.valueOf(lowerCaseLetter).toUpperCase();
        } else {
          decryptedText += lowerCaseLetter;
        }
      }
    }
    return decryptedText;
  }
}
