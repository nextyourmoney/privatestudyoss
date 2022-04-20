package com.mycompany.myapp.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.myapp.controller.dto.Ch14Member;

@Mapper
public interface Ch14memberDao {
	public int insert(Ch14Member member);
	public Ch14Member selectByMid(String mid);
}
