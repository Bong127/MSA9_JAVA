package Mission._15;

import java.util.ArrayList;

public class Library {

	public static void main(String[] args) {
		Book book1 = new Book("123123", "이게 자바냐", "감자바", "자바 감자바", "33000");
		Book book2 = new Book("112112", "정보처리기사", "김휴먼", "국가기술자격", "45000");
		Book book3 = new Book("001001", "실무 DB   ", "박디비", "디비디비딥", "60000");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		System.out.println("==========ALOHA 스터디 도서관==========");
		for (Book book : bookList) {
			System.out.println(book.getIsbn() + " | " + book.getTitle() + "	| " 
			+ book.getWriter() + "	| " + book.getContent() + "	| " + book.getPrice());
		}
	}
}
