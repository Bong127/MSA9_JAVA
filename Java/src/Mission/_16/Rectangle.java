package Mission._16;

public class Rectangle extends Shape {
	double width, height;

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	double area() {
		// 사각형의 넓이 : 가로 X 세로
		return width * height;
	}

	@Override
	double round() {
		// 사각형의 둘레 : (가로+세로)X2
		return (width+height)*2;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	
}
