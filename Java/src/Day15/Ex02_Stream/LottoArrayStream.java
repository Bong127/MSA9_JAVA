package Day15.Ex02_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoArrayStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임?");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print("[" + (i+1) + "게임] : ");
			//int lotto[] = new int[6];
			Set<Integer> set = new HashSet<Integer>();
			
			// 랜덤 수 6개를 대입 & 중복 제거
			while( set.size() < 6) {
				int rand = (int) (Math.random() * 45 +1);
				set.add(rand);
			}
			
			// 스트림을 사용하여 정렬 + 출력
			set.stream().
				sorted().											// 스트림 객체 생성
				forEach(lotto -> System.out.print(lotto + " "));	// 정렬
			System.out.println();									// 전체 반복
			
		}
		sc.close();
	}
}
