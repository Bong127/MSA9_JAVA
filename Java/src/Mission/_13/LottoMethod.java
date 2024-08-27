package Mission._13;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
		int rand;
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
					rand = random.nextInt(44) + 1;
					if(list[i].contains(rand))
						j--;
					else
						list[i].add(rand);
				}
			// 수동 입력
			}else {
				for (int j = 0; j < 6; j++) {
					System.out.print((j+1) + " : ");
					rand = sc.nextInt();
					// 숫자 1 ~ 45 아닐 시 재입력
					if(!(rand <= 45 && rand >= 1)) {
						System.out.println("숫자 45를 넘었습니다 다시 입력해주세요.");
						j--;
						continue;
					}
					// 숫자 중복시 재입력
					if(list[i].contains(rand))
						j--;
					else
						list[i].add(rand);
				}
			}
			// 오름차순 정렬
			Collections.sort(list[i]);
			
			// 정렬된 수 출력
			for (Integer result : list[i]) {
				System.out.print(result + " ");
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
		
		// 로또 만료일
		Calendar yearDay = Calendar.getInstance();
		
		// 이번주 토요일 21시 정각으로 설정
		sDay.set(Calendar.DAY_OF_WEEK, 7);
		sDay.set(Calendar.HOUR_OF_DAY, 21);
		sDay.set(Calendar.MINUTE, 0);
		sDay.set(Calendar.SECOND, 0);
		
		// 토요일 9시 이후 일 경우 7일 더하기
		if(toDay.after(sDay))
			sDay.add(Calendar.DATE, 7);
		
		// 1년뒤 날짜
		yearDay.setTime(sDay.getTime());
		yearDay.add(Calendar.DATE, 366);
		
		// 날짜 및 시간 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd일 (E) HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd일 (E)");
		
		// 현재 날짜 포맷
		String toDayFormat = sdf.format(toDay.getTime());
		
		// 토요일 날짜 포맷
		String sDayFormat = sdf.format(sDay.getTime());
		
		// 1년뒤 날짜 포맷
		String yearDayFormat = sdf2.format(yearDay.getTime());
		
		// 로또 출력
		System.out.println("################## 인생역전Lottoria #################");
		System.out.print("발행일	: ");
		System.out.println(toDayFormat);
		System.out.print("추첨일	: ");
		System.out.println(sDayFormat);
		System.out.print("지급기한	: ");
		System.out.println(yearDayFormat);
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
	
	// 당첨 번호 생성
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
		Collections.sort(winning);
		
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
