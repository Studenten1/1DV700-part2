package assignment1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transposition {
    protected String SECRET_KEY;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String textPath = "./src/main/java/assignment1/";
    String myName = "Linda Meyer";
    String decryptedMessage = "";
    String encryptedMessage = "";
  
    /**
     * The constructor.
     */
    public Transposition(String theKey, String theTextFile) {
      SECRET_KEY = theKey.toLowerCase();
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
        String str = "";
        while (scanner.hasNextLine()) {
          str += scanner.nextLine();
        }
        decryptedMessage += getDecryption(str);
        scanner.close();
      } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
        e.printStackTrace();
      }
      return decryptedMessage;
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
      char[][]table = new char[nrOfRows][nrOfColumns];

      for (int i = 0; i < nrOfRows; i++) {
        String word = (str.substring(i * nrOfColumns, ((i + 1) * nrOfColumns)));
        for (int a = 0; a < nrOfColumns; a++) {
          table[i][a] = word.charAt(a);
        }
      }

      String encryptedWord = "";
      ArrayList<String> words = new ArrayList<>();
      for (int m = 0; m < nrOfColumns; m++) {
        for (int n = 0; n < nrOfRows; n++) {
          encryptedWord += table[n][m];
        }
        words.add(encryptedWord);
        encryptedWord = "";
      }

      String[] wordsInOrder = new String[nrOfColumns];
      for (int z = 0; z < words.size(); z++) {
        int order  = sequence[z];
        wordsInOrder[(order - 1)] = words.get(z);
      }

      for (int c = 0; c < nrOfColumns; c++) {
        encryptedText += wordsInOrder[c];
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
      int nrOfRows = (int)Math.ceil(str.length() / SECRET_KEY.length());
      char[][]table = new char[nrOfRows][SECRET_KEY.length()];

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

      ArrayList<String> encryptedWords = new ArrayList<>();
      for (int m = 0; m < SECRET_KEY.length(); m++) {
        encryptedWords.add(str.substring(m * nrOfRows, (m + 1) * nrOfRows));
      }

      count = 1;
      ArrayList<String> wordsInOrder = new ArrayList<>();
      for (int z = 0; z < SECRET_KEY.length(); z++) {
        if (sequence[z] == count) {
          wordsInOrder.add(z, encryptedWords.get(0));
        } else if (sequence[z] == (count + 1)) {
          wordsInOrder.add(z, encryptedWords.get((count)));
        } else if (sequence[z] == (count + 2)) {
          wordsInOrder.add(z, encryptedWords.get((count + 1)));
        } else if (sequence[z] == (count + 3)) {
          wordsInOrder.add(z, encryptedWords.get((count + 2)));
        } else if (sequence[z] == (count + 4)) {
          wordsInOrder.add(z, encryptedWords.get((count + 3)));
        } else if (sequence[z] == (count + 5)) {
          wordsInOrder.add(z, encryptedWords.get((count + 4)));
        } else if (sequence[z] == (count + 6)) {
          wordsInOrder.add(z, encryptedWords.get((count + 5)));
        } else {
          wordsInOrder.add(z, encryptedWords.get((count + 6)));
        }
      }

      for (int i = 0; i < nrOfRows; i++) {
        for (int c = 0; c < SECRET_KEY.length(); c++) {
          table[i][c] = wordsInOrder.get(c).charAt(i);
        }
      } 

      for(int e = 0; e < table.length; e++) {
        for(int a = 0; a < SECRET_KEY.length(); a++) {
          decryptedText += table[e][a];
        }
      } 

      return decryptedText;
    }
}
