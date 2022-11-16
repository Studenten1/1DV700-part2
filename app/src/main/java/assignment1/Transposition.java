package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Transposition {
    protected String SECRET_KEY;
    private ArrayList<String> rows = new ArrayList<>();
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private StringBuilder plainText = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    private StringBuilder cipherText;
    private String textPath = "./src/main/java/assignment1/";
    String myName = "Linda Meyer";
    String decryptedText = "";
    String encryptedMessage = "";
  
    /**
     * The constructor.
     */
    public Transposition(String theKey, String theTextFile) {
      SECRET_KEY = theKey.toLowerCase();
      textPath = textPath.concat(theTextFile);
    }
  
    /**
     * The other constructor, only for testing to decrypt a message without the key.
     */
    public Transposition(String theTextFile) {
      textPath = textPath.concat(theTextFile);
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
        String message = "";
        while (scanner.hasNext()) {
          message += scanner.nextLine();
        }
        message += (" " + myName);
        encryptedMessage = getEncryption(message);
        scanner.close();
      } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
        e.printStackTrace();
      }
      return encryptedMessage;
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
      StringBuilder cipher = new StringBuilder("defghijkl-nopqrs-uvwx-z-bc");
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
      ArrayList<Integer> indexInAlphabet = new ArrayList<>();
      int[] sequence = new int[SECRET_KEY.length()];
      for (int a = 0; a < SECRET_KEY.length(); a++) {
        indexInAlphabet.add(alphabet.indexOf(SECRET_KEY.charAt(a)));
      }
      int count = 1;
      for (int b = 0; b < alphabet.length(); b++) {
        for (int c = 0; c < indexInAlphabet.size(); c++) {
          if (indexInAlphabet.get(c) == b) {
            sequence[c] = count;
            count++;
          }
        }
      }

      int nrOfColumns = SECRET_KEY.length();
      int nrOfRows = (int)Math.ceil(str.length() / nrOfColumns);
      for (int i = 0; i < nrOfRows; i++) {
        if (i == (nrOfRows - 1)) {
          int nrOfStars = str.length() - (nrOfRows * nrOfColumns);
          String lastRow = str.substring(i * nrOfColumns, str.length() - 1);
          String stars = "";
          while (stars.length() < nrOfStars) {
            stars += "*";
          }
          lastRow += stars;
          rows.add(lastRow);
        } else {
          rows.add(str.substring(i * nrOfColumns, ((i + 1) * nrOfColumns)));
        }
      }

      String word = "";
      count = 1;
      ArrayList<String> words = new ArrayList<>();

      for (int m = 0; m < nrOfColumns; m++) {
        for (int n = 0; n < rows.size(); n++) {
          word += rows.get(n).charAt(m);
        }
        words.add(word);
        word = "";
      }

      for (int z = 0; z < nrOfColumns; z++) {
        if (sequence[z] == count) {
          encryptedText += (words.get(0) + " ");
        } else if (sequence[z] == (count + 1)) {
          encryptedText += (words.get(count) + " ");
        } else if (sequence[z] == (count + 2)) {
          encryptedText += (words.get(count + 1) + " ");
        } else if (sequence[z] == (count + 3)) {
          encryptedText += (words.get(count + 2) + " ");
        } else if (sequence[z] == (count + 4)) {
          encryptedText += (words.get(count + 3) + " ");
        } else if (sequence[z] == (count + 5)) {
          encryptedText += (words.get(count + 4) + " ");
        } else if (sequence[z] == (count + 6)) {
          encryptedText += (words.get(count + 5) + " ");
        } else {
          encryptedText += (words.get(count + 6) + " ");
        }
      }

      System.out.print(words);
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
