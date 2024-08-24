package Mission._17;

public class RcCar implements RemoteControl {
	
	int speed;
	int battery;
	
	public RcCar() {
		this.battery = 100;
	}

	@Override
	public void turnOn() {
		System.out.println("RC카 전원을 켭니다.");
		setBattery(getBattery()-40);
		if(getBattery()<0)
			setBattery(0);
	}

	@Override
	public void turnOff() {
		System.out.println("RC카 전원을 끕니다.");
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		if( speed > MAX_SPEED ) {
			this.speed = MAX_SPEED;
			System.err.println("최대 속력!");
		}
		else if( speed < MIN_SPEED ) {
			this.speed = MIN_SPEED;
			System.err.println("최저 속력!");
		}
		else {
			this.speed = speed;
		}
		System.out.println("현재 속도 : " + this.speed);
	}

	@Override
	public void changeBatter() {
		if(getBattery()==0) {
			setBattery(100);
			System.out.println("Rc카의 배터리를 교체하였습니다.");
			System.out.println("남은 Rc카의 배터리 " + getBattery() + "%");
		}
		else {
			System.out.println("남은 Rc카의 배터리 " + getBattery() + "%");
		}
	}

}
