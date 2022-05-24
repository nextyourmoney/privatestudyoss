package com.mycompany.myapp.dao.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.dto.Ch14Member;

@Repository
public class Ch14memberDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insert(Ch14Member member) {
		int rows = sqlSessionTemplate.insert("com.mycompany.myapp.dao.mybatis.Ch14memberDao.insert", member);
		return rows;
		
	}
	public Ch14Member selectByMid(String mid) {
		Ch14Member ch14Member = sqlSessionTemplate.selectOne("com.mycompany.myapp.dao.mybatis.Ch14memberDao.selectByMid",mid);
		return ch14Member;
		
		
	}
}
