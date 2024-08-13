package Mission._10;

public class Trapezoid {
	double top, bottom, height;

	public Trapezoid() {
	}

	public Trapezoid(double top, double bottom, double height) {
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	
	public double getArea() {
		return (top + bottom) * height / 2;
	}

	@Override
	public String toString() {
		return "Trapezoid [top=" + top + ", bottom=" + bottom + ", height=" + height + "]";
	}
}
