package Mission._16;

public class Circle extends Shape {
	double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		// 원의 넓이 = (원주율) X (반지름) X (반지름) 
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	double round() {
		// 원의 둘레 = 2 X (원주율) X (반지름
		return 2 * Math.PI * radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
