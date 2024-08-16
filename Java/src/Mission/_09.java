package Mission;

import java.util.Scanner;

public class _09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name[] = new String[10]; // 성명
		int money[] = new int[10]; // 간식비
		int divide[] = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 }; // 화폐단위
		int sum[] = new int[10]; // 전체화폐매수
		int n = 0; // 입력 개수
		
		// 데이터 입력
		while (true) {
			System.out.print("성명 : ");
			name[n] = sc.next();
			if (name[n].equals("QUIT")) {
				break;
			} else {
				System.out.print("간식비 지급 : ");
				money[n] = sc.nextInt();
				n++;
			}
		}
		
		// 출력
		System.out.println("성명  출장비	오만원	만원	오천원	천원	오백원	백원	오십원	십원	오원	일원");
		for (int i = 0; i < n; i++) {
			System.out.print(name[i] + "  " + money[i]);
			for (int j = 0; j < 10; j++) {
				sum[j] += money[i] / divide[j];
				// 해당 화폐 개수 출력
				System.out.printf("	%3d", money[i] / divide[j]);
				// 남은 돈
				money[i] %= divide[j];
			}
			System.out.println();
		}
		// 전체화폐매수 출력
		System.out.print("전체화폐매수 :");
		for (int i = 0; i < 10; i++) {
			System.out.printf("	%3d", sum[i]);
		}
		sc.close();
	}
}
