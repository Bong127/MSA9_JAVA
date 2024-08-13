package Mission._17;

public interface RemoteControl {

	int MAX_SPEED = 300;
	int MIN_SPEED = 0;
	
	void turnOn();
	void turnOff();
	void setSpeed(int speed);
	
	default void parking(boolean check) {
		if(check) {
			System.out.println("주차 되었습니다.");
			setSpeed(MIN_SPEED);
		}
		else {
			System.out.println("주행 모드를 시작합니다");
			setSpeed(10);
		}
	}

	static void changeBatter() {
		System.out.println("배터리를 교체하였습니다.");
	}
}
