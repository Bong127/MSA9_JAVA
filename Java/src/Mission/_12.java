package Mission;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class _12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random random = new Random();
		int condition = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 게임 개수
		for (int z = 1; z <= n; z++) {
			// 랜덤 정수 입력
			for (int i = 0; i < 6; i++) {
				list.add(random.nextInt(44) + 1);
				// 중복 정수 제거
				do {
					for (int j = 0; j < i; j++) {
						if (list.get(j) == list.get(i)) {// 중복 발견시 반복문 탈출 및 condition 0으로 변경(while문 탈출 불가)
							condition = 0;
							break;
						} else
							condition = 1;
					}
					if (condition == 0) // 중복 발견시 새로운 정수 입력
						list.set(i, random.nextInt(44) + 1);
				} while (condition != 1); // condition이 1인 경우(중복이 발견되지 않은 경우)
			}
			// 점수 출력
			System.out.print("[" + z + " 게임]");
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			list.clear();
			System.out.println();
		}
		sc.close();
	}
}
