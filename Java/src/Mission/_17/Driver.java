package Mission._17;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RemoteControl carRc = new RcCar();
		RemoteControl droneRc = new Drone();
		while(true) {
			System.out.println("사용할 기기를 선택해주세요.");
			System.out.println("1.Rc카  2.드론  0.종료");
			System.out.print(">> ");
			int choice = sc.nextInt();
			if(choice<0 || choice>2) {
				System.out.println("0 ~ 2 사이의 숫자를 선택해주세요");
				continue;
			}
			if(choice == 0) {
				System.out.println("종료되었습니다.");
				break;
			}
			else if (choice == 1) {
				carRc.turnOn();	
				System.out.print("속도를 설정해주세요 >> ");
				carRc.setSpeed(sc.nextInt());			
				carRc.turnOff();		
				carRc.changeBatter();
				System.out.println();
			}
			else if (choice == 2) {
				droneRc.turnOn();
				System.out.print("속도를 설정해주세요 >> ");
				droneRc.setSpeed(sc.nextInt());
				droneRc.turnOff();
				droneRc.changeBatter();
				System.out.println();
			}
		}
	}
}
