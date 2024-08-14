package Mission._13;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lotto lotto = Lotto.Run();
		System.out.print("몇 게임? ");
		int n = sc.nextInt();
		ArrayList<Integer>[] list = lotto.selectNum(n);
	}
}
