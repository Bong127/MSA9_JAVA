package Mission._13;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lotto lotto = Lotto.Run();
		int n;
		do {
			System.out.print("몇 게임? ");
			n = sc.nextInt();
			if(n>5)
				System.out.println("5개 이하로 입력해주세요!");
		} while (n>5);
		
		// 복권 발행
		ArrayList<Integer>[] list = lotto.selectNum(n);
		
		// 복권 출력
		lotto.LottoPrint(list);
		
		// 당첨 번호 추첨
		lotto.LottoFinal(list);
		sc.close();
	}
}