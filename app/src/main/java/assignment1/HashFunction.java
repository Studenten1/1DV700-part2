package assignment1;

import java.util.ArrayList;

public class HashFunction { 
  private final int range = 256;
  private ArrayList<Integer> table = new ArrayList<>();
  private ArrayList<Integer> shuffleTable = new ArrayList<>();

  public HashFunction () {
    setShuffleTable();
  }

  public void setShuffleTable(){
    for (int a = 0; a < range; a++) {
      table.add(a);
    }

    do {
      int randomNumber = (int)(Math.random() * table.size()) + 0;
      shuffleTable.add(table.get(randomNumber));
      table.remove(randomNumber);
    } while (table.size() > 0);
  }
  
  public int getHashCode(String input){
    int hash = input.length() % range;
    for (int a = 0; a < input.length(); a++) {
      hash = shuffleTable.get(hash ^ input.codePointAt(a));
    }
    return hash;
  }
}
