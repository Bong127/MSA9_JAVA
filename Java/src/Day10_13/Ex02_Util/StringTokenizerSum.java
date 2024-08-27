package Day10_13.Ex02_Util;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerSum {
	// 1+2+3+4+5
	// "+" --분리--> 1 2 3 4 5 (String)
	// 문자열 토큰을 (int) 타입으로 변환하여 합계를 구해보자.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(input, "+");
		int sum = 0;
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			int item = Integer.parseInt(token);
			sum += item;
		}
		
		System.out.println("합계 : " + sum);
		sc.close();
	}
}
