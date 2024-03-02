package shapes;
/**
 * Pyramid.java
 * 
 * Class Definition: Represents a pyramid shape.
 * Extends the Shape class and provides methods to calculate
 * its volume and base area.
 */
public class Pyramid extends Shape {
	// Attributes
    private double side;
	/**
	 * Constructor method to create a new Pyramid object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The Pyramid object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height the height value of the pyramid.
	 * @param side the edge length value of the pyramid.
	 */
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }
	/**
	 * Override method to calculate the base area of the pyramid.
	 * 
	 * Precondition: A valid Pyramid object exists.
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
	 * Override method to calculate the volume of the pyramid.
	 * 
	 * Precondition: A valid Pyramid object exists.
	 * 
	 * Postcondition: A double value representing the volume value.
	 * 
	 * @return the volume value as a double value.
	 */
    @Override
    public double calcVolume() {
        return this.calcBaseArea() * height * (1.0 / 3.0);
    }
   
}
