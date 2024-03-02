package shapes;
/**
 * Prism.java
 *
 * Class Definition: Represents an abstract prism shape.
 * Extends the Shape class and provides methods to calculate
 * its volume and base area.
 */
public abstract class Prism extends Shape {
	// Attributes
    protected double side;
	/**
	 * Constructor method to create a new Prism object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition: The Prism object is created 
	 * with the specified height and edge length.
	 * 
	 * @param height the height value of the prism.
	 * @param side the edge length value of the prism.
	 */
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }
	/**
	 * Accessor method to return the edge length value.
	 * 
	 * Precondition: A valid Prism object exists.
	 * 
	 * Postcondition: A double value representing the edge length value.
	 * 
	 * @return the edge length value as a double value.
	 */
    public double getSide() {
        return side;
    }
	/**
	 * Mutator method to modify the value of the edge length.
	 * 
	 * Precondition: A valid Prism object exists and a double value
	 * is passed.
	 * 
	 * Postcondition: The edge length is changed to the value specified
	 * in the argument.
	 * 
	 * @param side the new edge length value.
	 */
	public void setSide(double side) {
		this.side = side;
	} 
    /**
     * Abstract method to calculate the volume of the prism.
     */
    public abstract double calcVolume();
    /**
     * Abstract method to calculate the base area of the prism.
     */
    public abstract double calcBaseArea();
}