package Day07.Review;

import java.util.Scanner;

/**
 *  더조은컴퓨터아카데미에서 김조은 팀장에게 예산을 주고
 *  에어컨을 구매하라고 지시하였다
 *  이때 에어컨 구매비는 다음과 같이 현금으로 지급한다.
 *  구매비		: 657825
 *  50000		: 13개
 *  10000		: 0개
 *  5000		: 1개
 *  1000		: 2개
 *  500			: 1개
 *  100			: 3개
 *  50			: 0개
 *  10			: 2개
 *  5			: 1개
 *  1			: 0개
 *  위와 같이 입력하면,
 *  큰 화폐단위부터 계산하며, 화폐단윌별로 화폐매수를 출력하는 프로그램을 작성하시오.
 *  
 */
public class Ex03_화폐매수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매비		: ");
		int divide = 50000;
		int money = sc.nextInt();
		boolean sw = true;
		while(money >= 1) {
			System.out.println(divide+"		: "+money/divide+"개");
			money%=divide;
			if(sw) 
				divide/=5;
			else
				divide/=2;
			sw = !sw;
		}
		sc.close();
	}
}
