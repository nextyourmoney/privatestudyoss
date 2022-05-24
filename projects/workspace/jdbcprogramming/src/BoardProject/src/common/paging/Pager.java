package common.paging;

import java.util.Scanner;

import lombok.Data;

@Data
public class Pager {
	private int totalRows;      //전체 행수
	private int totalPageNo;   //전체 페이지 수
	private int totalGroupNo;   //전체 그룹 수
	private int startPageNo;   //그룹의 시작 페이지 번호
	private int endPageNo;      //그룹의 끝 페이지 번호
	private int pageNo;         //현재 페이지 번호
	private int pagesPerGroup;   //그룹당 페이지 수
	private int groupNo;      //현재 그룹 번호
	private int rowsPerPage;   //페이지당 행 수 
	private int startRowNo;      //페이지의 시작 행 번호(1, ..., n)
	private int startRowIndex;   //페이지의 시작 행 인덱스(0, ..., n-1) for mysql
	private int endRowNo;      //페이지의 마지막 행 번호
	private int endRowIndex;   //페이지의 마지막 행 인덱스
	Scanner scanner;
	public Pager(int rowsPerPage, int pagesPerGroup,int totalRows,int pageNo) {
		scanner=new Scanner(System.in);
		this.rowsPerPage=rowsPerPage;
		this.pagesPerGroup=pagesPerGroup;
		this.totalRows=totalRows;
		this.pageNo=pageNo;

		this.totalPageNo=(int)(Math.ceil((double)totalRows/rowsPerPage));
		this.totalGroupNo=(int)(Math.ceil((double)totalPageNo/pagesPerGroup));

		this.groupNo=(pageNo-1)/pagesPerGroup+1;
		this.startPageNo=(groupNo-1) * pagesPerGroup +1;
		this.endPageNo=startPageNo+pagesPerGroup -1;
		if(groupNo==totalGroupNo) endPageNo=totalPageNo;
		this.startRowNo=(pageNo-1)*rowsPerPage+1;
		this.endRowNo=pageNo*rowsPerPage;

	}
	
	
}
