package assignment1;

import java.util.ArrayList;

public class HashTests {
  private ArrayList<Integer> uniformityTestArray = new ArrayList<>();
  private StringBuilder letterNumber = new StringBuilder("abcdefghijklmnopqrstuvwxyz123456789");
  private HashFunction newHashFunction;
  private final int range = 256;

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
  
  public ArrayList<Integer> getUniformityTestArray(){
    for (int a = 0; a < 4000; a++) {
      String randomInput = getRandomInput();
      int hashCode = newHashFunction.getHashCode(randomInput);
      uniformityTestArray.add(hashCode);
    }
    return uniformityTestArray;
  } 

  public double getUniformityDistributionResult(ArrayList<Integer> arrayOfValues, int nrOfKeys){
    double denominator = ((nrOfKeys/(2 * 256))*(nrOfKeys + (2 * 256) - 1));
    double numerator = 0;

    for (int a = 0; a < range; a++) { 
      int count = 0;
      for (Integer integer : arrayOfValues) {
        if (integer == a) {
          count++;
        }
      }
      numerator += (count * (count + 1) / 2);
    }
    double result = (numerator / denominator);
    return result;
  } 

  public ArrayList<StringBuffer> getArrayWithSimilarStrings(){
    ArrayList<StringBuffer> arrayWithSimilarStrings = new ArrayList<>();
    int length = 8;
    StringBuffer input = new StringBuffer();
    for (int a = 0; a < length; a++) {
      int randomIndex = (int)(Math.random() * letterNumber.length()) + 0;
      input.append(letterNumber.charAt(randomIndex));
    }
    arrayWithSimilarStrings.add(input);

    StringBuffer newString = arrayWithSimilarStrings.get(0);
    for (int a = 0; a < 1200; a++) {
      int randomIndex = (int)(Math.random() * letterNumber.length()) + 0;
      do {
        newString.setCharAt((a % length), letterNumber.charAt(randomIndex));
      } while (newString.charAt((a % length)) != letterNumber.charAt(randomIndex));
      arrayWithSimilarStrings.add(newString);
    }

    return arrayWithSimilarStrings;
  }

  public ArrayList<Integer> getUniformityTestArrayForSimilarInput(){
    ArrayList<StringBuffer> arrayWithStrings = new ArrayList<>();
    ArrayList<Integer> arrayWithHashValues = new ArrayList<>();
    arrayWithStrings = getArrayWithSimilarStrings();

    for (int a = 0; a < arrayWithStrings.size(); a++) {
      String theInput = arrayWithStrings.get(a).toString();
      int hashCode = newHashFunction.getHashCode(theInput);
      arrayWithHashValues.add(hashCode);
    }
    return arrayWithHashValues;
  } 

  public void printInputStringsAndHashValues(){
    for (int a = 0; a < 4000; a++) {
      String randomInput = getRandomInput();
      System.out.print(randomInput + " -> ");
      int hashCode = newHashFunction.getHashCode(randomInput);
      System.out.println(hashCode);
    }
  } 

}
