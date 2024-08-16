package Mission._13;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	private static Lotto lotto = new Lotto();
	int temp;
	Random random = new Random();
	ArrayList<Integer> winning = new ArrayList<Integer>();
	
	private Lotto() {
		for (int i = 0; i < 7; i++) {
			winning.add(random.nextInt(44) + 1);
			for (int j = 0; j < i; j++) {
				if (winning.get(j) == winning.get(i)) {
					winning.remove(i);
					i--;
					break;
				}
			}
		}
		for (int i = 1; i < 7; i++) {
			for (int j = i; j > 0; j--) {
				if( winning.get(j-1) > winning.get(j)) {
					temp = winning.get(j);
					winning.set(j, winning.get(j-1));
					winning.set(j-1, temp);
				}
			}
		}
		for (int i = 0; i < winning.size(); i++) {
			System.out.print(winning.get(i) + " ");
		}
	}
	
	// 복권 번호 뽑기
	public ArrayList<Integer>[] selectNum(int n) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
			System.out.print("["+(i+1)+" 게임] (1.자동 / 2.수동) : ");
			list[i].add(sc.nextInt());
			if(!(list[i].get(0)==1 || list[i].get(0)==2)) {
				System.out.println("1 또는 2를 입력해주세요!");
				i--;
				break;
			}
			// 자동 입력
			if(list[i].get(0)==1) {
				// 중복 배제 랜덤 수 입력
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
				// 오름차순 정렬
				for (int j = 2; j < 7; j++) {
					for (int j2 = j; j2 > 1; j2--) {
						if( list[i].get(j2-1) > list[i].get(j2)) {
							temp = list[i].get(j2);
							list[i].set(j2, list[i].get(j2-1));
							list[i].set(j2-1, temp);
						}
					}
				}
				// 정렬된 수 출력
				for (int j = 1; j < 7; j++) {
					System.out.print(list[i].get(j) + " ");
				}
				System.out.println();
			// 수동 입력
			}else {
				for (int j = 1; j < 7; j++) {
					System.out.print(j + " : ");
					list[i].add(sc.nextInt());
					// 숫자 1 ~ 45 아닐 시 재입력
					if(!(list[i].get(j) <= 45 && list[i].get(j) >= 1)) {
						System.out.println("숫자 45를 넘었습니다 다시 입력해주세요.");
						list[i].remove(j);
						j--;
						continue;
					}
					// 숫자 중복시 재입력
					for (int j2 = 1; j2 < j; j2++) {
						if (list[i].get(j2) == list[i].get(j)) {
							System.out.println("숫자가 중복됩니다 다시 입력해주세요.");
							list[i].remove(j);
							j--;
							break;
						}
					}
				}
				// 오름차순 정렬
				for (int j = 2; j < 7; j++) {
					for (int j2 = j; j2 > 1; j2--) {
						if( list[i].get(j2-1) > list[i].get(j2)) {
							temp = list[i].get(j2);
							list[i].set(j2, list[i].get(j2-1));
							list[i].set(j2-1, temp);
						}
					}
				}
				// 정렬된 수 출력
				for (int j = 1; j < 7; j++) {
					System.out.print(list[i].get(j) + " ");
				}
				System.out.println();
			}
		}
		sc.close();
		return list;
	}
	
	// 복권 발행
	public void LottoPrint(ArrayList<Integer>[] list) {
		LocalDate nowDay = LocalDate.now();
		Date date = new Date();
		LocalDate yearDay = nowDay.plusDays(366);
		LocalTime nowTime = LocalTime.now();
		String time = nowTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		String today = nowDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String remainDay = yearDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		DayOfWeek dayOfWeek = nowDay.getDayOfWeek();
		DayOfWeek dayofweek2 = yearDay.getDayOfWeek();
		Calendar ca = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ca.set(Calendar.DAY_OF_WEEK, 7);
		ca.set(Calendar.HOUR_OF_DAY, 21);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		if(date.after(ca.getTime()))
		{
			ca.add(Calendar.DATE, 7);
		}
		String nextDay = sdf.format(ca.getTime());
		System.out.println("################## 인생역전Lottoria #################");
		System.out.print("발행일	: ");
		System.out.print(today+"일  ");
		System.out.printf("(%s)  ",dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));
		System.out.println(time);
		System.out.print("추첨일	: ");
		System.out.println(nextDay+"일  (토)  21:00:00");
		System.out.print("지급기한	: ");
		System.out.print(remainDay+"일  ");
		System.out.printf("(%s)  ", dayofweek2.getDisplayName(TextStyle.NARROW, Locale.KOREAN));
		System.out.println();
		System.out.println("---------------------------------------------------");
		char charNum = 'A';
		for (ArrayList<Integer> arrayList : list) {
			System.out.print(charNum + " ");
			charNum++;
			for (int i = 0; i < arrayList.size() ; i++) {
				if(i == 0 ) {
					if(arrayList.get(i) == 1)
						System.out.print("자 동 ");
					else
						System.out.print("수 동 ");
				}
				else
					System.out.printf("%2d	", arrayList.get(i));
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------");
		System.out.println("금액				  	₩" + list.length+",000");
		System.out.println("###################################################");
	}
	
	// 당첨 번호 맞춰보기
	public void LottoFinal(ArrayList<Integer>[] list) {
		int count=0, bonusCount=0;
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(winning.get(i)+" ");
		}
		System.out.println();
		System.out.println("보너스 번호 : " + winning.get(6));
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < list[i].size(); j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					
					if( list[i].get(j) == winning.get(j2) ) {
						if(j2 == 6)
							bonusCount++;
						else
							count++;
					}
				}
			}
			switch (count) {
			case 3:
				list[i].add(5);
				break;
			case 4:
				list[i].add(4);
				break;
			case 5:
				if(bonusCount == 1) {
					list[i].add(2);
				}
				else
					list[i].add(3);
				break;
			case 6:
				list[i].add(1);
				break;
			default:
				list[i].add(0);
				break;
			}
			count = 0;
			bonusCount = 0;
		}
		System.out.println("##################### 당첨 결과 #####################");
		char charNum = 'A';
		for (ArrayList<Integer> arrayList : list) {
			System.out.print(charNum + " ");
			charNum++;
			for (int i = 0; i < arrayList.size() ; i++) {
				if(i == 0 ) {
					if(arrayList.get(i) == 1)
						System.out.print("자 동 ");
					else
						System.out.print("수 동 ");
				}
				else {
					if (i==7) {
						if(arrayList.get(i) == 0)
							System.out.print("(낙첨)");
						else
							System.out.printf("%2d등", arrayList.get(i));
					}
					else
						System.out.printf("%2d	", arrayList.get(i));
				}
			}
			System.out.println();
		}
		System.out.println("###################################################");
	}
	
	public static Lotto Run() {
		return lotto;
	}
	
}
