package shapes;
/**
 * Cone.java
 * 
 * Class Definition: Represents a cone shape.
 * Extends the Shape class and provides methods to calculate
 * its volume and base area.
 */
public class Cone extends Shape {
	// Attributes
    private double radius;
	/**
	 * Constructor method to create a new Cone object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The Cone object is created 
	 * with the specified height and radius.
	 * 
	 * @param height the height value of the cone.
	 * @param radius the radius value of the cone.
	 */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
	/**
	 * Override method to calculate the base area of the cone.
	 * 
	 * Precondition: A valid Cone object exists.
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
	 * Override method to calculate the volume of the cone.
	 * 
	 * Precondition: A valid Cone object exists.
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
