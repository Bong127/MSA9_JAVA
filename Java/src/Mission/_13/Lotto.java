package Mission._13;

import java.util.ArrayList;

public class Lotto {
	
	private static Lotto lotto = new Lotto();
	ArrayList<Integer>[] list; // 뽑은 복권 번호
	ArrayList<Integer> winning; // 당첨 번호
	ArrayList<String> auto; // 복권 자동 뽑기 여부
	ArrayList<Integer> result; // 결과
	// 생성자 당첨 번호
	private Lotto() {
		auto =  new ArrayList<String>();
		result = new ArrayList<Integer>();
	}
	
	public Lotto(ArrayList<Integer>[] list, ArrayList<Integer> winning) {
		this.list = list;
		this.winning = winning;
	}

	public ArrayList<Integer>[] getList() {
		return list;
	}

	public void setList(ArrayList<Integer>[] list) {
		this.list = list;
	}

	public ArrayList<Integer> getWinning() {
		return winning;
	}

	public void setWinning(ArrayList<Integer> winning) {
		this.winning = winning;
	}

	public ArrayList<String> getAuto() {
		return auto;
	}

	public void setAuto(ArrayList<String> auto) {
		this.auto = auto;
	}

	public ArrayList<Integer> getResult() {
		return result;
	}

	public void setResult(ArrayList<Integer> result) {
		this.result = result;
	}

	public static Lotto Run() {
		return lotto;
	}
	
}
