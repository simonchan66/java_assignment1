package shapes;

public abstract class Prism extends Shape {
    protected double side;

    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    
    public abstract double calcVolume();

    public abstract double calcBaseArea();
}