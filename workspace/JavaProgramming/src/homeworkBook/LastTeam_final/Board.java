package homeworkBook.LastTeam_final;

import java.io.Serializable;

public class Board extends Member implements Serializable{
	private int bno;//게시글 번호
	private String title;//제목
	private String writer;//글쓴이
	private String content;//게시글 내용
	private String postingDate;
	
	//목록 보기용 Board객체.	
//	public Board(int bno, String title, String writer, String content) {
//		super();
//		this.bno = bno;
//		this.title = title;
//		setWriter(writer);//작성자는 로그인한 userId로 할 것!
//		this.lastModifiedDate = lastModifiedDate;
//		this.content = content;
//	}
	public Board(int bno, String title, String writer, String content, String postingDate) {
		super();
		this.bno = bno;
		this.title = title;
		setWriter(writer);//작성자는 로그인한 userId로 할 것!
//		this.lastModifiedDate = lastModifiedDate;
		this.content = content;
		this.postingDate = postingDate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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
	
	public String getPostingDate() {
		return postingDate;
	}
	
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	
}
