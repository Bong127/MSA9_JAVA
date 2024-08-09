package Day04;

import java.util.Scanner;

public class Ex03_Min {
	public static void main(String[] args) {
		// 첫 번재 줄에 입력할 개수 N을 입력받고,
		// 둘째 줄에 N개의 정수를 공백을 두고 입력받으시오.
		// N개의 정수 중, 최솟값을 구하시오.
		// (입력예시)
		// 5
		// 67 55 80 90 100
		// (출력)
		// 최솟값 : 55
		
		/*
		  		(순서도)
		  		1. 정수 하나 입력받아서 N에 대입
		  		2. N번 만큼 N개의 정수 입력받아서 배열 arr 대입
		  		3. 배열을 반복해서 최솟값 min 배열의 i번째 요소와 비교
		  		4. 두 요소 중에서 더 작은 요소를 min에 대입
		  		5. 반복 끝나고, min를 출력
		
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 개수 : ");
		int N = sc.nextInt();
		int arr[] = new int[N];
		int min= Integer.MAX_VALUE;
		
		for(int i=0 ; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			if(min > arr[i])
				min = arr[i];
		}
		System.out.println("최솟값 : " + min);
		sc.close();
	}
}
