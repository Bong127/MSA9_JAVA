package Mission;

import java.util.Scanner;

public class _01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eng,math,java;
		
		// 점수 입력
		eng = sc.nextInt();
		math = sc.nextInt();
		java = sc.nextInt();
		
		// 점수 출력
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("자바 점수 : " + java);
		System.out.println("총점 : " + (eng+math+java));
		System.out.printf("평균 : %.1f", (double)(eng+math+java)/3);
		sc.close();
	}
}
