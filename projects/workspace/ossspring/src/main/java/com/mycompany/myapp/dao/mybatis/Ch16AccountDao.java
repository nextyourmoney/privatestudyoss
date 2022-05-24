package com.mycompany.myapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.myapp.controller.dto.Ch14Member;
import com.mycompany.myapp.controller.dto.Ch16Account;

@Mapper
public interface Ch16AccountDao {
	public List<Ch16Account> selectAll();
	public Ch16Account selectByAno(int ano);
	public int UpdateBalance(Ch16Account account);
}
