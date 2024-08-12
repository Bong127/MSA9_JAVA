package Mission;

import java.util.Random;
import java.util.Scanner;

public class _06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random random = new Random();
		int x = random.nextInt(44)+1;
		int condition = 1;
		int arr[] = new int[6];
		// 게임 개수
		for (int z = 1; z <= n; z++) {
			// 랜덤 정수 입력
			for (int i = 0; i < arr.length; i++) {
				arr[i] = random.nextInt(44)+1;
				// 중복 정수 제거
				do {
					for (int j = 0; j < i; j++) {
						if(arr[j] == arr[i]) {// 중복 발견시 반복문 탈출 및 condition 0으로 변경(while문 탈출 불가)
							condition = 0;
							break;
						}else
							condition = 1;
					}
					if(condition == 0) // 중복 발견시 새로운 정수 입력
						arr[i] = random.nextInt(44)+1;
				} while (condition!=1); // condition이 1인 경우(중복이 발견되지 않은 경우)
			}
			// 점수 출력
			System.out.print("[" + z + " 게임]");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
