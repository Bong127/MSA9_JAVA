package Mission;

import java.util.Scanner;

public class _05 {
	static int count = 0;
	public static String order(int n) {
		String order;
		switch (n) {
		case 1:
			order = "‘황금올리브 반반한 치킨’이(/가) 주문되었습니다.";
			count++;
			break;
		case 2:
			order = "‘뿌잉클치킨’이(/가) 주문되었습니다.";
			count++;
			break;
		case 3:
			order = "‘처갓집에서 호식이가 만든 치킨’이(/가) 주문되었습니다.";
			count++;
			break;
		default:
			order = "(0~3) 사이의 번호를 입력해주세요.";
			break;
		}
		return order;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("**********치킨메뉴판**********");
			System.out.println("1.  황금올리브 반반한 치킨");
			System.out.println("2.  뿌잉클 치킨");
			System.out.println("3.  처갓집에서 호식이가 만든 치킨");
			System.out.println("0.  종료");
			System.out.print("**********번호 : ");
			n = sc.nextInt();
			if(n==0)
				break;
			else
				System.out.println(order(n));
		} while (n!=0);
		System.out.println("총 " + count + "개의 상품이 주문되었습니다.");
		
		sc.close();
	}
}
