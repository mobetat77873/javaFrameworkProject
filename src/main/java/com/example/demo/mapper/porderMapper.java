package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.porder;
import com.example.demo.vo.queryMemberPorder;

@Mapper
public interface porderMapper {
	//C
	@Insert("insert into porder(porderNO,memberNO,productNO,amount) values(#{porderNO},#{memberNO},#{productNO},#{amount})")
	void addPorder(porder p);
	//R
	@Select("select * from queryMemberPorder where memberNO=#{memberNO}")
	List<queryMemberPorder> queryMemberAllPorder(String memberNO);
	//U
	//D
	@Delete("delete from porder where porderNO=#{porderNO}")
	public void delete(int porderNO);
}
