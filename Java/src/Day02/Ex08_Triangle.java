package Day02;

import java.util.Scanner;

public class Ex08_Triangle {

	public static void main(String[] args) {
		
		// 삼각형 넓이 : (밑변) X (높이) /2
		// 밑변과 높이를 입력받아서 삼각형의 넓이를 계산하고 출력하시오.
		
		Double width, height, area;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("밑변 : ");
		width = sc.nextDouble();
		System.out.print("높이 : ");
		height = sc.nextDouble();
		
		area = (width * height) / 2;
		
		System.out.println("넓이 : " + area );
		
		sc.close();
		

	}

}
