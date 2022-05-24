package ch14.sec02.exam06;

import java.util.Date;

public class Board implements Serializable{

	
		
		private int bnol;
		private String title;
		private String content;
		private String writer;
		private Date date;
		
		public Board(int bno, String title, String content, String writer, Date date) {
			this.bnol = bno;
			this.title = title;
			this.content = content;
			this.writer = writer;
			this.date = date;
		}
		
		
		
		
			
		
		

	}

}
