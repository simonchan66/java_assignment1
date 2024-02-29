package shapes;

public class Cone extends Shape {
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    @Override
    public double calcBaseArea() {
    	return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public double calcVolume() {
        return this.calcBaseArea() * height * (1.0 / 3.0);
    }  
    
}
