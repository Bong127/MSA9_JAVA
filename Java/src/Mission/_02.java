package Mission;

import java.util.Scanner;

public class _02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 입력
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		int sum=0;
		
		// 홀수의 합
		for (int i = 1; i <= n; i+=2) {
			sum+=i;
			if(i == n-1)
				System.out.print(i+"=");
			else
				System.out.print(i+"+");
		}
		System.out.println(sum);
		
		sum = 0;
		
		// 짝수의 합
		for (int i = 2; i <= n; i+=2) {
			sum+=i;
			if(i == n)
				System.out.print(i+"=");
			else
				System.out.print(i+"+");
		}
		System.out.println(sum);
		
		// 약수
		for (int i = 1; i <= n; i++) {
			if(n%i == 0)
				System.out.print(i+" ");
		}
		
		sc.close();
	}
}
