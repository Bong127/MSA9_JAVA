package Mission._13;

import java.util.Scanner;

public class LottoRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lotto lotto = Lotto.Run();	// 로또 객체
		LottoMethod lottoMethod = new LottoMethod();// 로또 메소드
		
		// 당첨 번호 생성
		lotto.setWinning(lottoMethod.lottoNumber());
		
		// 당첨 번호 출력(테스트용)
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(lotto.getWinning().get(i)+" ");
		}
		System.out.println();
		System.out.println("보너스 번호 : " + lotto.getWinning().get(6));
		
		// 게임 개수 입력(1 ~ 5 사이로 입력)
		int n;
		do {
			System.out.print("몇 게임? ");
			n = sc.nextInt();
			if(!(n>=1 && n<=5))
				System.out.println("1~5 사이로 입력해주세요!");
		} while (!(n>=1 && n<=5));
		
		// 복권 발행
		lotto.setList(lottoMethod.selectNum(n, lotto.getAuto()));
		
		// 복권 출력
		lottoMethod.LottoPrint(lotto);
		
		// 당첨 확인
		lotto.setResult(lottoMethod.LottoFinal(lotto.getList(), lotto.getWinning()));
		
		// 최종 결과 출력
		lottoMethod.result(lotto);
		
		sc.close();
	}
}