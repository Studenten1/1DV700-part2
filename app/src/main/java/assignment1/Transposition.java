package assignment1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.UUID;

public class Transposition {
    protected final String SECRET_KEY;
    private char plainText[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char cipherText[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private StringBuilder text;
    private String textPath = ".\\";
    private String lmPath = ".\\lm222sp.txt";


    /**
     * The constructor.
     */
    public Transposition(String theKey, String theText) {
        SECRET_KEY = theKey.toLowerCase();
        textPath = textPath.concat(theText);
    }

    /**
     * Gets the name of the boat.
     *
     * @return name - (string)
     */
    public void encryptText() {
        for (int a = 0; a < SECRET_KEY.length(); a++) {
            for (int i = 0; i < plainText.length; i++) {
                if(plainText[i] == SECRET_KEY.charAt(a)){
                    System.out.println(cipherText[i]);
                }
            }
        }

    }

    /**
     * Gets the name of the boat.
     *
     * @return name - (string)
     */
    public void decryptText() {
        
    }

        /**
     * Loads the data and converts it to a list of objects.
     *
     */
    public void loadEncryptedTextFile() {
        try {
        File file = new File(lmPath);
        Scanner scanner = new Scanner(file, "utf-8");

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            str.replace("Add your Message here", "");
        }
        scanner.close();
        } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
        e.printStackTrace();
        }
    }

    /**
     * Overwrites the data and saves the file.
     *
     */
        /**public void save() {
         try {
        text = new StringBuilder();
        text.append("\n");
        File outFile = new File(path);
        PrintWriter printer = new PrintWriter(outFile, "utf-8");
        printer.print(text);
        printer.close();
        } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
        e.printStackTrace();
        }
    }
    */
}
