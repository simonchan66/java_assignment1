package shapes;
/**
 * OctagonalPrism.java
 * 
 * Class Definition: Represents a octagonal prism shape.
 * Extends the Prism class and provides methods to calculate
 * its volume and base area.
 */
public class OctagonalPrism extends Prism {
	/**
	 * Constructor method to create a new OctagonalPrism object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The OctagonalPrism object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height the height value of the octagonal prism.
	 * @param side the edge length value of the octagonal prism.
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}
	/**
	 * Override method to calculate the base area of the octagonal prism.
	 * 
	 * Precondition: A valid OctagonalPrism object exists.
	 * 
	 * Postcondition: A double value representing the base area value.
	 * 
	 * @return the base area value as a double value.
	 */
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
	}
	/**
	 * Override method to calculate the volume of the octagonal prism.
	 * 
	 * Precondition: A valid OctagonalPrism object exists.
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