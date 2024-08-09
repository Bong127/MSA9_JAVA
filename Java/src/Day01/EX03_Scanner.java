package Day01;

import java.util.Scanner;

// import 하는 법
// 1. 클래스 : ctrl + space
// 2. 전체 import  : ctrl + shift + O(영어)

public class EX03_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a : ");
		int a = sc.nextInt();
		
		System.out.println("a : " + a);
		
		// close(): scanner 객체를 메모리에서 해제하는 메소드
		sc.close();
		
		//sc.nextInt();
		// * Scanner 객체를 해제한 이후에는 더이상 입력을 받을 수 없다.
	}
}
