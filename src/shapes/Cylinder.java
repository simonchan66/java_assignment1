package shapes;
/**
 * Cylinder.java
 * 
 * Class Definition: Represents a cylinder shape.
 * Extends the Shape class and provides methods to calculate
 * its volume and base area.
 */
public class Cylinder extends Shape {
	// Attributes
    private double radius;
	/**
	 * Constructor method to create a new Cylinder object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The Cylinder object is created 
	 * with the specified height and radius.
	 * 
	 * @param height - the height value of the cylinder.
	 * @param radius - the radius value of the cylinder.
	 */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }
	/**
	 * Override method to calculate the base area of the cylinder.
	 * 
	 * Precondition: A valid Cylinder object exists.
	 * 
	 * Postcondition: A double value representing the base area value.
	 * 
	 * @return the base area value as a double value.
	 */
    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }
	/**
	 * Override method to calculate the volume of the cylinder.
	 * 
	 * Precondition: A valid Cylinder object exists.
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
