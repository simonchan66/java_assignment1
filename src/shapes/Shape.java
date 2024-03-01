package shapes;
/**
 * Shape.java
 *
 * Class Definition: Represents an abstract shape.
 * Provides methods to calculate its volume and base area.
 */
public abstract class Shape {
	// Attributes
    protected double height; 
	/**
	 * Constructor method to create a new Shape object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The Shape object is created 
	 * with the specified height.
	 * 
	 * @param height - the height value of the shape.
	 */
    public Shape(double height) {
        this.height = height;
    }
	/**
	 * Accessor method to return the height value.
	 * 
	 * Precondition: A valid Shape object exists.
	 * 
	 * Postcondition: A double value representing the height value.
	 * 
	 * @return the height value as a double value.
	 */
    public double getHeight() {
        return height;
    }
	/**
	 * Mutator method to modify the value of the height.
	 * 
	 * Precondition: A valid Shape object exists and a double value
	 * is passed.
	 * 
	 * Postcondition: The height is changed to the value specified
	 * in the argument.
	 * 
	 * @param height - the new height value.
	 */
	public void setHeight(double height) {
		this.height = height;
	}
    /**
     * Abstract method to calculate the volume of the shape.
     */
    public abstract double calcVolume();
    /**
     * Abstract method to calculate the base area of the shape.
     */
    public abstract double calcBaseArea();
	/**
	 * Override toString method from Shape Object.
	 * 
	 * Precondition: A valid Shape object exists.
	 * 
	 * Postcondition: A String of the shape type value.
	 * 
	 * @return the String representation of the shape type value.
	 */
	@Override
	public String toString() {
	    // Default case, prints only the shape type
	    return getClass().getSimpleName();
	}
}
