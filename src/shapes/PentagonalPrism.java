package shapes;
/**
 * PentagonalPrism.java
 * 
 * Class Definition: Represents a pentagonal prism shape.
 * Extends the Prism class and provides methods to calculate
 * its volume and base area.
 */
public class PentagonalPrism extends Prism {
	/**
	 * Constructor method to create a new PentagonalPrism object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The PentagonalPrism object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height - the height value of the pentagonal prism.
	 * @param side - the edge length value of the pentagonal prism.
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}
	/**
	 * Override method to calculate the base area of the pentagonal prism.
	 * 
	 * Precondition: A valid PentagonalPrism object exists.
	 * 
	 * Postcondition: A double value representing the base area value.
	 * 
	 * @return the base area value as a double value.
	 */
	@Override
	public double calcBaseArea() {
		return 5 * Math.pow(side, 2) * Math.tan(54) / 4;
	}
	/**
	 * Override method to calculate the volume of the pentagonal prism.
	 * 
	 * Precondition: A valid PentagonalPrism object exists.
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
