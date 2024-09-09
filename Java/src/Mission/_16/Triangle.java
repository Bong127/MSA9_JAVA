package Mission._16;

public class Triangle extends Shape {
	double width, height;

	public Triangle() {
	}

	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double area() {
		// 삼각형의 넓이 = (가로)X(세로)/2
		return width * height / 2;
	}

	@Override
	double round() {
		// *정삼각형
		// 삼각형의 둘레 = 3 * width
		return 3 * width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}
	
}
