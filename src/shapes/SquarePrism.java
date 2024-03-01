package shapes;
/**
 * SquarePrism.java
 * 
 * Class Definition: Represents a square prism shape.
 * Extends the Prism class and provides methods to calculate
 * its volume and base area.
 */
public class SquarePrism extends Prism {
	/**
	 * Constructor method to create a new SquarePrism object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The SquarePrism object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height - the height value of the square prism.
	 * @param side - the edge length value of the square prism.
	 */
	public SquarePrism(double height, double side) {
		super(height, side);
	}
	/**
	 * Override method to calculate the base area of the square prism.
	 * 
	 * Precondition: A valid SquarePrism object exists.
	 * 
	 * Postcondition: A double value representing the base area value.
	 * 
	 * @return the base area value as a double value.
	 */
	@Override
	public double calcBaseArea() {
		return Math.pow(side, 2);
	}
	/**
	 * Override method to calculate the volume of the square prism.
	 * 
	 * Precondition: A valid SquarePrism object exists.
	 * 
	 * Postcondition: A double value representing the volume value.
	 * 
	 * @return the volume value as a double value.
	 */
	@Override
	public double calcVolume() {
		return this.calcBaseArea() * height;
	}
}
