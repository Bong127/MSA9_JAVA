package Mission._17;

public interface RemoteControl {

	final int MAX_SPEED = 200;
	final int MIN_SPEED = 0;
	
	void turnOn();
	void turnOff();
	void setSpeed(int speed);
	void changeBatter();
}
