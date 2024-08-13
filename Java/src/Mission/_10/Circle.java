package Mission._10;

public class Circle {

	double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}
