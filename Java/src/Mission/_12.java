package Mission;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class _12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random random = new Random();
		List<Integer> list = new Vector<Integer>();
		int temp;
		// 게임 개수
		for (int z = 1; z <= n; z++) {
			// 랜덤 정수 입력
			for (int i = 0; i < 6; i++) {
				list.add(random.nextInt(44) + 1);
				// 중복 정수 제거
				for (int j = 0; j < i; j++) {
					if (list.get(j) == list.get(i)) {
						list.remove(i);
						i--;
						break;
					}
				}
			}
			// 오름차순 정렬
			for (int i = 1; i < 6; i++) {
				for (int j = i; j > 0; j--) {
					if( list.get(j-1) > list.get(j)) {
						temp = list.get(j);
						list.set(j, list.get(j-1));
						list.set(j-1, temp);
					}
				}
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
