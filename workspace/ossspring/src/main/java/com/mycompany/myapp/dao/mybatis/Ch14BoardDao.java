package com.mycompany.myapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.myapp.controller.dto.Ch14Board;
import com.mycompany.myapp.controller.dto.Ch14Member;
import com.mycompany.myapp.controller.dto.Pager;

@Mapper
public interface Ch14BoardDao {
	
	public List<Ch14Board> selecrtByPage(Pager pager);
	public Ch14Board selectByBno(int bno);
	public int insert(Ch14Board board);
	public int deleteByBno(int bno);
	public int update(Ch14Board board);
	public int count();
	
}
