package Boatclub;

/**
 * This is the List class.
 */
public class List {
  private String name;
  private int position;
  private int noOfMoons;
  private int aphelion;
  private int perihelion;

  /**
   * The constructor.
   */
  public SinglePlanet(String theName, int thePosition, int numberOfMoons, int theAphelion, int thePerihelion) {
    setName(theName);
    setPosition(thePosition);
    setNoMoons(numberOfMoons);
    setAphelion(theAphelion);
    setPerihelion(thePerihelion);
  }
}
