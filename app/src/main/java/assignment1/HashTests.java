package assignment1;

import java.util.ArrayList;

public class HashTests {
  private ArrayList<Integer> uniformityTestArray = new ArrayList<>();
  private StringBuilder letterNumber = new StringBuilder("abcdefghijklmnopqrstuvwxyz123456789");
  private HashFunction newHashFunction;

  public HashTests () {
    newHashFunction = new HashFunction();
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
  
  public void printUniformityTestArray(){
    for (int a = 0; a < 4000; a++) {
      String randomInput = getRandomInput();
      int hashCode = newHashFunction.getHashCode(randomInput);
      uniformityTestArray.add(hashCode);
    }
    System.out.print(uniformityTestArray);
  } 
}
