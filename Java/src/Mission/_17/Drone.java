package Mission._17;

public class Drone implements RemoteControl {

	int speed;
	int battery;
	
	public Drone() {
		this.battery = 100;
	}

	@Override
	public void turnOn() {
		System.out.println("드론 전원 ON");
	}

	@Override
	public void turnOff() {
		System.out.println("드론 전원 OFF");
		setBattery(getBattery()-(getSpeed()/2));
		if(getBattery()<0)
			setBattery(0);
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
		if( speed > MAX_SPEED) {
			this.speed = MAX_SPEED;
			System.err.println("최대 속력");
		}
		else if( speed < MIN_SPEED) {
			this.speed = MIN_SPEED;
			System.err.println("최저 속력");
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
			System.out.println("드론의 배터리를 교체하였습니다.");
			System.out.println("남은 드론의 배터리 " + getBattery() + "%");
		}
		else {
			System.out.println("남은 드론의 배터리 " + getBattery() + "%");
		}
	}
}
