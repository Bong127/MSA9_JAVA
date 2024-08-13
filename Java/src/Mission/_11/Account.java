package Mission._11;

public class Account {
	
	private String bankNum, name;
	private int balance, pw;
	
	public Account() {
		this("계좌없음", "이름없음", 0, 0);
	}

	public Account(String bankNum, String name, int balance, int pw) {
		this.bankNum = bankNum;
		this.name = name;
		this.balance = balance;
		this.pw = pw;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	
}
