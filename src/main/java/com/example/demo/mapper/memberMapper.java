package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.member;

@Mapper
public interface memberMapper {
	//C
	@Insert("insert into member(memberNO,name,username,password,address) "
			+ "values(#{memberNO},#{name},#{username},#{password},#{address})")
	public void addMember(member m);
	
	
	//R
	@Select("select * from member where username=#{username}")
	public member queryUsername(String username);
	@Select("select * from member where username=#{username} and password=#{password}")
	public member queryUser(String username, String password);
	//U
	@Update("update member set name=#{name},password=#{password},address=#{address} where username=#{username}")
	public void updateMember(String memberNO,String name,String password,String address,String username);
	//D
}
