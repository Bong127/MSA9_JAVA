package Mission._13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class LottoMethod {
	int temp;
	Random random = new Random();
	
	// 복권 번호 뽑기
	public ArrayList<Integer>[] selectNum(int n, ArrayList<String> auto) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>[] list = new ArrayList[n];
		int autoNum;
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
			System.out.print("["+(i+1)+" 게임] (1.자동 / 2.수동) : ");
			autoNum = sc.nextInt();
			if(!(autoNum==1 || autoNum==2)) {
				System.out.println("1 또는 2를 입력해주세요!");
				i--;
				continue;
			}
			if(autoNum == 1)
				auto.add("자 동");
			else
				auto.add("수 동");
			// 자동 입력
			if(autoNum==1) {
				// 중복 배제 랜덤 수 입력
				for (int j = 0; j < 6; j++) {
					list[i].add(random.nextInt(44) + 1);
					for (int j2 = 0; j2 < j; j2++) {
						if (list[i].get(j2) == list[i].get(j)) {
							list[i].remove(j);
							j--;
							break;
						}
					}
				}
				// 오름차순 정렬
				for (int j = 1; j < 6; j++) {
					for (int j2 = j; j2 > 0; j2--) {
						if( list[i].get(j2-1) > list[i].get(j2)) {
							temp = list[i].get(j2);
							list[i].set(j2, list[i].get(j2-1));
							list[i].set(j2-1, temp);
						}
					}
				}
			// 수동 입력
			}else {
				for (int j = 0; j < 6; j++) {
					System.out.print((j+1) + " : ");
					list[i].add(sc.nextInt());
					// 숫자 1 ~ 45 아닐 시 재입력
					if(!(list[i].get(j) <= 45 && list[i].get(j) >= 1)) {
						System.out.println("숫자 45를 넘었습니다 다시 입력해주세요.");
						list[i].remove(j);
						j--;
						continue;
					}
					// 숫자 중복시 재입력
					for (int j2 = 0; j2 < j; j2++) {
						if (list[i].get(j2) == list[i].get(j)) {
							System.out.println("숫자가 중복됩니다 다시 입력해주세요.");
							list[i].remove(j);
							j--;
							break;
						}
					}
				}
				// 오름차순 정렬
				for (int j = 1; j < 6; j++) {
					for (int j2 = j; j2 > 0; j2--) {
						if( list[i].get(j2-1) > list[i].get(j2)) {
							temp = list[i].get(j2);
							list[i].set(j2, list[i].get(j2-1));
							list[i].set(j2-1, temp);
						}
					}
				}
			}
			// 정렬된 수 출력
			for (int j = 0; j < 6; j++) {
				System.out.print(list[i].get(j) + " ");
			}
			System.out.println();
		}
		sc.close();
		return list;
	}
	
	// 뽑은 복권 발행
	public void LottoPrint(Lotto lotto) {
		ArrayList<Integer>[] list = lotto.getList();
		ArrayList<String> auto = lotto.getAuto();
		// 현재 날짜
		Calendar toDay = Calendar.getInstance();
		// 이번주 토요일
		Calendar sDay = Calendar.getInstance();	
		// 1년뒤 날짜
		Calendar yearDay = Calendar.getInstance();	
		
		// 이번주 토요일 21시 정각으로 설정
		sDay.set(Calendar.DAY_OF_WEEK, 7);
		sDay.set(Calendar.HOUR_OF_DAY, 21);
		sDay.set(Calendar.MINUTE, 0);
		sDay.set(Calendar.SECOND, 0);
		
		// 토요일 9시 이후 일 경우 7일 더하기
		if(toDay.after(sDay))
			sDay.add(Calendar.DATE, 7);
		
		// 현재 날짜로부터 1년 뒤
		yearDay.add(Calendar.DATE, 366);
		
		// 날짜 및 시간 형식
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
		
		// 현재 날짜, 시간, 요일
		String toDay_Day = formatDay.format(toDay.getTime());
		String toDay_Time = formatTime.format(toDay.getTime());
		String toDay_Week = toDay.getDisplayName(Calendar.DAY_OF_WEEK, 	Calendar.NARROW_FORMAT, Locale.KOREAN);
		
		// 토요일 날짜
		String sDay_Day = formatDay.format(sDay.getTime());
		
		// 1년뒤 날짜, 요일
		String yearDay_Day = formatDay.format(yearDay.getTime());
		String yearDay_Week = yearDay.getDisplayName(Calendar.DAY_OF_WEEK, 	Calendar.NARROW_FORMAT, Locale.KOREAN);
		
		// 로또 출력
		System.out.println("################## 인생역전Lottoria #################");
		System.out.print("발행일	: ");
		System.out.print(toDay_Day+"일  ");
		System.out.print("(" + toDay_Week + ")  ");
		System.out.println(toDay_Time);
		System.out.print("추첨일	: ");
		System.out.println(sDay_Day+"일  (토)  21:00:00");
		System.out.print("지급기한	: ");
		System.out.print(yearDay_Day+"일  ");
		System.out.print("(" + yearDay_Week + ")	");
		System.out.println();
		System.out.println("---------------------------------------------------");
		char charNum = 'A';
		for (int i = 0; i < list.length; i++) {
			System.out.print(charNum + " ");
			charNum++;
			System.out.print(auto.get(i) + " ");
			for (int j = 0; j < list[i].size() ; j++)
				System.out.printf("%2d	", list[i].get(j));
			System.out.println();
		}
		System.out.println("---------------------------------------------------");
		System.out.println("금액				  	₩" + list.length+",000");
		System.out.println("###################################################");
	}
	
	// 당첨 번호
	public ArrayList<Integer> lottoNumber() {
		ArrayList<Integer> winning = new ArrayList<Integer>();
		// 중복 방지
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
		
		// 오름차순 정렬
		for (int i = 1; i < 7; i++) {
			for (int j = i; j > 0; j--) {
				if( winning.get(j-1) > winning.get(j)) {
					temp = winning.get(j);
					winning.set(j, winning.get(j-1));
					winning.set(j-1, temp);
				}
			}
		}
		return winning;
	}
	
	// 당첨 번호 맞춰보기
	public ArrayList<Integer> LottoFinal(ArrayList<Integer>[] list, ArrayList<Integer> winning) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int count=0, bonusCount=0;
		// 당첨, 보너스 번호 출력
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(winning.get(i)+" ");
		}
		System.out.println();
		System.out.println("보너스 번호 : " + winning.get(6));
		
		// 당첨 확인
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					
					if( list[i].get(j) == winning.get(j2) ) {
						if(j2 == 6)
							bonusCount++;
						else
							count++;
					}
				}
			}
			switch (count) { // 당첨 결과 입력
			case 3:
				result.add(5);
				break;
			case 4:
				result.add(4);
				break;
			case 5:
				if(bonusCount == 1) {
					result.add(2);
				}
				else
					result.add(3);
				break;
			case 6:
				result.add(1);
				break;
			default:
				result.add(0);
				break;
			}
			count = 0;
			bonusCount = 0;
		}
		return result;
	}
	
	// 당첨 결과 출력
	public void result(Lotto lotto) {
		ArrayList<Integer>[] list = lotto.getList(); 
		ArrayList<String> auto = lotto.getAuto(); 
		ArrayList<Integer> result = lotto.getResult(); 
		// 당첨 결과 출력
		System.out.println("########################## 당첨 결과 ##########################");
		char charNum = 'A';
		for (int i = 0; i < list.length; i++) {
			System.out.print(charNum + " ");
			charNum++;
			System.out.print(auto.get(i) + " ");
			for (int j = 0; j < list[i].size() ; j++) {
				System.out.printf("%2d	", list[i].get(j));
			}
			if(result.get(i) == 0)
				System.out.print("(낙첨)");
			else
				System.out.print(result.get(i)+"등");
			System.out.println();
		}
		System.out.println("#############################################################");
	}
}
