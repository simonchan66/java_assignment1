package shapes;

public class SquarePrism extends Prism {

	public SquarePrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea() {
		return Math.pow(side, 2) * Math.sqrt(3) / 4;
	}
	
	@Override
	public double calcVolume() {
		return this.calcBaseArea() * height;
	}
}
