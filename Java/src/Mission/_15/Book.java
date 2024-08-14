package Mission._15;

public class Book {
	
	String isbn, title, writer, content, price;
	
	public Book() {
		this("번호없음","제목없음","저자명없음","내용없음","가격없음");
	}

	public Book(String price) {
		this.price = price;
	}

	public Book(String isbn, String title, String writer, String content, String price) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", content=" + content + ", price="
				+ price + "]";
	}
}
