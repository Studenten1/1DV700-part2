package assignment1;

import java.util.ArrayList;

public class HashTests {
  private ArrayList<Integer> uniformityTestArray = new ArrayList<>();
  StringBuilder letterNumber = new StringBuilder("abcdefghijklmnopqrstuvwxyz123456789");

  public HashTests () {
  }

  public String getRandomInput(){
    int length = (int)(Math.random() * 11) + 1;
    String randomInput = "";
    for (int a = 0; a < length; a++) {
      int randomIndex = (int)(Math.random() * letterNumber.length()) + 0;
      randomInput += letterNumber.charAt(randomIndex);
    }
    return randomInput;
  }
  
  public void getHashCode(String input){
  } 
}
