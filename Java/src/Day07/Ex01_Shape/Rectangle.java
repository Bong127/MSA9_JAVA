package Day07.Ex01_Shape;

public class Rectangle extends Shape {
	double width, height;
	
	// 생성자
	public Rectangle() {
		this(0,0);
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	// 추상 메소드 구현
	@Override
	double area() {
		return width * height;
	}

	@Override
	double round() {
		return (width+height)*2;
	}

	
	// getter setter
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

	
	// toString
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

}
