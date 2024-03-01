package shapes;
/**
 * TriangularPrism.java
 * 
 * Class Definition: Represents a triangular prism shape.
 * Extends the Prism class and provides methods to calculate
 * its volume and base area.
 */
public class TriangularPrism extends Prism {
	/**
	 * Constructor method to create a new TriangularPrism object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The TriangularPrism object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height - the height value of the triangular prism.
	 * @param side - the edge length value of the triangular prism.
	 */
	public TriangularPrism(double height, double side) {
        super(height, side); // Assuming side length is the same as the base length in a triangular prism
    }
	/**
	 * Override method to calculate the base area of the triangular prism.
	 * 
	 * Precondition: A valid TriangularPrism object exists.
	 * 
	 * Postcondition: A double value representing the base area value.
	 * 
	 * @return the base area value as a double value.
	 */
	@Override
	public double calcBaseArea() {
		return Math.pow(side, 2) * Math.sqrt(3) / 4;
	}
	/**
	 * Override method to calculate the volume of the triangular prism.
	 * 
	 * Precondition: A valid TriangularPrism object exists.
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
