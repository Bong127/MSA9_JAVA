package Day09.Ex07_Review.인터페이스;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BoardAccess implements BoardInterface {
	// 게시글 개수
	int count = 5;
	// 게시글 목록
	Board[] boardList = {
		new Board(1,"제목01", "작성자01", "내용01", "2024/08/20 - 10:00", "2024/08/20 - 10:00"),	
		new Board(2,"제목02", "작성자02", "내용02", "2024/08/20 - 10:00", "2024/08/20 - 10:00"),	
		new Board(3,"제목03", "작성자03", "내용03", "2024/08/20 - 10:00", "2024/08/20 - 10:00"),	
		new Board(4,"제목04", "작성자04", "내용04", "2024/08/20 - 10:00", "2024/08/20 - 10:00"),	
		new Board(5,"제목05", "작성자05", "내용05", "2024/08/20 - 10:00", "2024/08/20 - 10:00")	
	};
	/**
	 * 게시글 등록
	 * 1. 매개변수로 넘겨받은 board 객체에 게시글 번호를 부여한다.
	 * 2. 등록일자와, 수정일자를 현재 날짜/시간으로 지정한다.
	 * 3. board 객체를 현재까지 등록된 배열요소 다음 index에 저장한다.
	 * 4. 등록된 board 객체를 반환한다.
	 */
	@Override
	public Board create(Board board) {
		if(this.count == 5) {
			System.out.println("게시글 목록이 꽉 찼습니다.");
			return null;
		}
		Date ca = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd - HH:mm");
		String toDay = formatter.format(ca);
		int boardNo = count++;
		board.setNo(boardNo);
		String regDate = toDay;
		String upDate = toDay;
		board.setRegDate(regDate);
		board.setUpDate(upDate);
		boardList[count-1] = board;
		System.out.println(board);
		System.out.println("게시글이 등록되었습니다.");
		return board;
	}
	/**
	 * 게시글 목록
	 * 1. 게시글이 존재하는지 확인하고 1개의 게시글도 없으면 null 반환
	 * 2. 게시글이 존재하면, 전체 개시글 배열인 boardList를 반환
	 */
	@Override
	public Board[] list() {
		if(this.count == 0) {
			System.out.println("조회된 게시글이 없습니다.");
			return null;
		}
		else {
			System.out.println("게시글 목록을 조회합니다.");
			return boardList;
		}
	}
	/**
	 * 게시글 조회
	 * 1. 넘겨받은 게시글 번호 no가 유효하지 않으면, null 반환
	 * 2. 게시글 번호 no가 유효하면, 번호에 해당하는 boardList[]의 요소 반환
	 */
	@Override
	public Board read(int no) {
		// 유효하지 않은 경우
		if(no < 1 || no >5) {
			System.out.println("1~5번의 게시글만 존재합니다.");
			return null;
		}
		System.out.println(no + "번 게시글을 조회합니다.");
		return boardList[no-1];
	}
	
	/**
	 * 게시글 수정
	 * 1. 수정할 게시글 번호 no가 유효하지 않으면, 0 반환
	 * 2. 수정할 게시글 번호 no가 유효하면,
	 * 		- 번호에 해당하는 boardList[] 요소를 변경
	 * 		- 수정일자(upDate)를 현재 날짜/시간으로 변경
	 * 		- 수정된 게시글 수 1을 반환
	 */
	@Override
	public int update(Board board) {
		int no = board.getNo();
		if(no > 5 || no < 0) {
			System.out.println("1~5번 게시글만 존재합니다.");
			return 0;
		}
		
		Board oldBoard = boardList[no-1];
		String updateTitle = board.getTitle();
		String updateWriter = board.getWriter();
		String updateContent = board.getContent();
		
		oldBoard.setTitle(updateTitle);
		oldBoard.setWriter(updateWriter);
		oldBoard.setContent(updateContent);
		
		Date ca = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd - HH:mm");
		String toDay = formatter.format(ca);
		boardList[no-1] = oldBoard;
		board.setUpDate(toDay);
		return 1;
	}
	
	/**
	 * 게시글 삭제
	 * 1. 삭제할 게시글 번호 no가 유효하지 않으면, 0 반환
	 * 2. 게시글이 하나도 존재하지 않으면, 0반환
	 * 3. 삭제할 게시글 번호 no가 유효하면,
	 * 		- 번호에 해당하는 boardList[] 요소를 null로 변경
	 * 		- 해당 index 다음의 요소들을 앞으로 한 칸씩 당겨준다.
	 * 		- 게시글 개수 count를 1 감소시킨다.
	 */
	@Override
	public int delete(int no) {
		if(no > 5 || no < 0) {
			System.out.println("1~5번 게시글만 존재합니다.");
			return 0;
		}
		if(count == 0) {
			System.out.println("삭제할 게시글 없습니다.");
			return 0;
		}
		boardList[no-1] = null;
		for (int i = no ; i < boardList.length; i++) {
			// 바로 앞의 위치 = 현재 접근한 위치
			boardList[i-1] = boardList[i];
		}
		
		// 가장 마지막 위치의 객체는 null로 바꾼다.
		boardList[boardList.length-1] = null;
		
		// 삭제 후 게시글 개수 감소
		count--;
		
		// 글번호 재세팅 : 글번호를 1~....
		for (int i = 0; i < boardList.length; i++) {
			if(boardList[i] != null)
				boardList[i].setNo(i+1);
		}
		
		return 1;
	}

}
