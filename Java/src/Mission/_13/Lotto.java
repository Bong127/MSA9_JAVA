package Mission._13;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	private static Lotto lotto = new Lotto();
	
	int winning[] = new int[7];
	
	private Lotto() {
	}
	
	public ArrayList<Integer>[] selectNum(int n) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>[] list = new ArrayList[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
			System.out.print("["+(i+1)+" 게임] (1.자동 / 2.수동) : ");
			list[i].add(sc.nextInt());
			if(list[i].get(0)==1) {
				for (int j = 1; j < 7; j++) {
					list[i].add(random.nextInt(44) + 1);
					for (int j2 = 1; j2 < j; j2++) {
						if (list[i].get(j2) == list[i].get(j)) {
							list[i].remove(j);
							j--;
							break;
						}
					}
				}
				for (int j = 1; j < 7; j++) {
					System.out.print(list[i].get(j) + " ");
				}
				System.out.println();
			}else {
				for (int j = 0; j < 6; j++) {
					list[i].add(sc.nextInt());
				}
			}
		}
		sc.close();
		return list;
	}
	
	public static Lotto Run() {
		return lotto;
	}
	
}
