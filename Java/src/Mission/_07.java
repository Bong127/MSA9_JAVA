package Mission;

import java.util.Scanner;

public class _07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		int temp; // 교환 변수
		
		// 값 5개 입력
		for (int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
		}
		
		// 오름차순
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if(a[j] > a[j+1])
				{
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 내림차순
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if(a[j] < a[j+1])
				{
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i : a) {
			System.out.print(i+" ");
		}
		
		sc.close();
	}
}
