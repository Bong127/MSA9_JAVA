package Mission;

import java.util.Random;
import java.util.Scanner;

public class _06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임? ");
		int n = sc.nextInt();
		Random random = new Random();
		int arr[] = new int[6];
		int temp;
		// 게임 개수
		for (int z = 1; z <= n; z++) {
			// 랜덤 정수 입력
			for (int i = 0; i < arr.length; i++) {
				arr[i] = random.nextInt(44) + 1;
				// 중복 정수 제거
				for (int j = 0; j < i; j++) {
					if (arr[j] == arr[i]) {
						i--;
						break;
					}
				}
			}
			// 오름차순 정렬
			for (int i = 1; i < arr.length; i++) {
				for (int j = i; j > 0; j--) {
					if(arr[j-1] > arr[j]) {
						temp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = temp;
					}
				}
			}
			// 점수 출력
			System.out.print("[" + z + " 게임]");
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%2d  ", arr[i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
