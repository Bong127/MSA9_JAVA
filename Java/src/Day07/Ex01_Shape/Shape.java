package Day07.Ex01_Shape;

abstract public class Shape {
	Point point = new Point();
	
	// 넓이와 둘레를 구하는 추상 메소드를 정의하시오.
	// * 추상 메소드 : abstract 접근지정자 반환타입 메소드명( 매개변수 );
	
	abstract double area();
	abstract double round();
	
	// getter, setter 메소드를 정의하시오.
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	
}
