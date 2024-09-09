package Mission._11;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account[] = new Account[1000];
		int n, pw, money, count=0, end=1, success=0, masterNum=1111;
		String search;
		do {
			System.out.println("====================");
			System.out.println("1. 계좌등록");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 계좌조회");
			System.out.println("5. 계좌목록");
			System.out.println("6. 종료");
			System.out.println("====================");
			System.out.print("입력>> ");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("==========계좌등록==========");
				if(count>1000) {
					System.out.println("최대 고객수 1000명이 넘었습니다.");
					break;
				}
				account[count] = new Account();
				System.out.print("계좌번호>> ");
				account[count].setBankNum(sc.next());
				System.out.print("예금주>> ");
				account[count].setName(sc.next());
				System.out.print("최초예금액>> ");
				account[count].setBalance(sc.nextInt());
				System.out.print("비밀번호>> ");
				account[count].setPw(sc.nextInt());
				System.out.println("'" + account[count].getName() + "'님의 계좌가 개설되었습니다.");
				count++;
				break;
			case 2:
				System.out.println("==========입금==========");
				System.out.print("계좌번호>> ");
				success=0;
				search = sc.next();
				for (int i = 0; i < count; i++) {
					if(account[i].getBankNum().equals(search)) {
						success=1;
						System.out.print("입금액>> ");
						money = sc.nextInt();
						System.out.println("'"+account[i].getName()+"'님에게 입금하시는게 맞으십니까?");
						System.out.println("1. 예");
						System.out.println("2. 아니오");
						System.out.print("입력>> ");
						int choice = sc.nextInt();
						if(choice == 1) {
							account[i].setBalance(account[i].getBalance() + money);
							System.out.println("'"+account[i].getName()+"'님의 계좌에 "+money+" 원이 입금되었습니다.");
							break;
						}else {
							System.out.println("입금이 취소되었습니다.");
							break;
						}
					}
				}
				if(success==0)
					System.out.println("입력하신 계좌가 없습니다.");
				break;
			case 3:
				System.out.println("==========출금==========");
				System.out.print("계좌번호>> ");
				search = sc.next();
				success=0;
				for (int i = 0; i < count; i++) {
					if(account[i].getBankNum().equals(search)) {
						success=1;
						System.out.print("비밀번호>> ");
						pw = sc.nextInt();
						if(account[i].getPw() == pw) {
							System.out.print("출금액>> ");
							money = sc.nextInt();
							account[i].setBalance(account[i].getBalance()-money);
							System.out.println("'"+account[i].getName()+"'님의 계좌에 "+money+" 원이 출금되었습니다.");
							break;
						}
						else {
							System.err.println("비밀번호가 다릅니다.");
							break;
						}
					}
				}
				if(success == 0)
					System.out.println("입력하신 계좌가 없습니다.");
				break;
			case 4:
				System.out.println("==========계좌조회==========");
				System.out.print("계좌번호>> ");
				search = sc.next();
				success=0;
				for (int i = 0; i < count; i++) {
					if(account[i].getBankNum().equals(search)) {
						success=1;
						System.out.print("비밀번호>> ");
						pw = sc.nextInt();
						if(account[i].getPw() == pw) {
							System.out.println("'"+account[i].getName()+"'님의 계좌잔액은 "+ account[i].getBalance() +" 원 입니다.");
							break;
						}
						else {
							System.err.println("비밀번호가 다릅니다.");
							break;
						}
					}
				}
				if(success == 0)
					System.out.println("입력하신 계좌가 없습니다.");
				break;
			case 5:
				System.out.println("관리자 비밀번호>> ");
				if(masterNum == sc.nextInt()) {
					System.out.println("==========계좌목록==========");
					System.out.println("예금주		계좌번호		잔고");
					for (int i = 0; i < count; i++) {
						System.out.println(account[i].getName()+"		"+account[i].getBankNum() +"		"+account[i].getBalance());
					}
				}
				break;
			case 6:
				end=0;
				System.out.println("시스템을 종료합니다.");
				break;

			default:
				break;
			}
		}while(end!=0);
		
		sc.close();
	}
}
