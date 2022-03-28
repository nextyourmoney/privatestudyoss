package ch06.sec06.exam07;

public class Board {
	private int no;
	private String title;
	private String content;
	private boolean open; 
	private String[] comments;
	
	public void setComments(String[] comments) {
		this.comments = comments;
	}
	
	public String[] getComments() {
		return comments;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getNo() {
		return no;
	}
	
	public void setNO(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

}
