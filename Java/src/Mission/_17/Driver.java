package Mission._17;

public class Driver {
	public static void main(String[] args) {
		
		RemoteControl carRc = new RcCar();
		carRc.turnOn();			
		carRc.parking(false);	
		carRc.setSpeed(20);		
		carRc.parking(true);	
		carRc.turnOff();		
		System.out.println();
		
		RemoteControl.changeBatter();	
		System.out.println();
		
		RemoteControl droneRc = new Drone();
		droneRc.turnOn();
		droneRc.parking(false);
		droneRc.setSpeed(15);
		droneRc.parking(true);
		droneRc.turnOff();
		System.out.println();
	}
}
