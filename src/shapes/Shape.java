package shapes;

public abstract class Shape {
    protected double height; // Make height protected to allow access in subclasses

    // Constructor to initialize height
    public Shape(double height) {
        this.height = height;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calcVolume();
    public abstract double calcBaseArea();

    // Getter method for height
    public double getHeight() {
        return height;
    }
    
	public void setHeight(double height) {
		this.height = height;
	}
	
    // Override toString method to provide custom string representation of the shape
	@Override
	public String toString() {
	    // Default case, prints only the shape type
	    return getClass().getSimpleName();
	}
}
