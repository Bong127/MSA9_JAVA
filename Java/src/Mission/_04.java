package Mission;

import java.util.Scanner;

public class _04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		// 별의 개수
		int star = 1;
		
		for (int i = 0; i <= n; i++) {
			// 빈 공간 출력
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			// * 출력
			for(int j = 0; j < star; j++) {
				System.out.print("*");
			}
			System.out.println();
			star += 2;
		}
		
		sc.close();
	}
}
