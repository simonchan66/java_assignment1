package shapes;
import java.util.Comparator;
/**
 * BaseAreaComparator.java
 * 
 * Class Definition: Represents a comparator for comparing shapes based on their base areas.
 * Implements the Comparator interface to provide custom comparison logic.
 * 
 * @author Team Zelda
 * @version 2.0
 */
public class BaseAreaComparator implements Comparator<Shape> {
	/**
	 * Override method to compare two shapes based on their base areas.
	 * 
	 * Precondition: Two valid Shape object exists.
	 * 
	 * Postcondition: A integer of the compare result.
	 * 
	 * @param s1 the first shape to compare
     * @param s2 the second shape to compare
     * @return a negative integer, zero, or a positive integer as the first argument
     *         is less than, equal to, or greater than the second
	 */
    @Override
    public int compare(Shape s1, Shape s2) {
      return Double.compare(s1.calcBaseArea(), s2.calcBaseArea()); 
    }
}
  	