package common.dao;

import lombok.Data;

@Data
public class Pager {
	public int totalRows; //전체 행 //전체 개 
	public int totalPageNo; //전체 페이지 
	public int totalGroupNo; //전체 그룺 수
	public int startPageNo; //그룹의 시작 페이지 번
	public int endPageNo; //그룹의 끝 페이지 번
	public int PageNo;//현재 페이지 번호 //내가 보고싶은 페이지의 값
	public int PagesPerGroup; //그룹당 페이지  //한 그룹의 페이지의 
	public int groupNo; //현재 그룹 번
	public int rowsPerPage; //페이지당 행  //페이지 당 몇 개 보여 줄 것인가
	public int startRowNo; //페이지의 시작 행 번
	public int endRowNo; //페이지의 마지막 행 번
	
	public Pager(int rowsPerPage, int PagesPerGroup, int totalRows, int pageNo) {
		this.rowsPerPage = rowsPerPage;
		this.PagesPerGroup = PagesPerGroup;
		this.totalRows = totalRows;
		this.PageNo = pageNo;
		
		this.totalPageNo = (int)(Math.ceil ((double) totalRows / rowsPerPage)); //전체 값들을 원하는 개수만큼 분할한다. 
		this.totalGroupNo = (int)(Math.ceil ((double) totalPageNo / PagesPerGroup)); //전체 페이지들을 원하는 개수만큼 분할한다.
		
		this.groupNo = (pageNo - 1) / PagesPerGroup + 1; 
		
		this.startPageNo = (groupNo - 1) * PagesPerGroup + 1; //가장 첫번째 페이지이다. 1번 
		
		this.endPageNo = startPageNo + PagesPerGroup - 1;
		if(groupNo == totalGroupNo) endPageNo = totalPageNo;
		
		this.startRowNo = (pageNo - 1) * rowsPerPage + 1;
		this.endRowNo = pageNo * rowsPerPage;
		
		
	}


}
