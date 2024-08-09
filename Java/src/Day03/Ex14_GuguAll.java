package Day03;

import java.util.Scanner;

public class Ex14_GuguAll {
	public static void main(String[] args) {
		// (단)X(1~9)
		// 단에 대한 반복	: 1~9
		// 각 단의 곱		: 1~9
		
		// 중첩 반복문(이중 반복문)
		// A X B
		for(int A = 1; A < 10; A++) {
			for(int B = 1; B < 10; B++) {
				System.out.print(A+"X"+B+"="+(A*B));
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
