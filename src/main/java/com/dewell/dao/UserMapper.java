package com.dewell.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dewell.common.easyuitool.PageTool;
import com.dewell.model.User;


public interface UserMapper {

	int deleteByPrimaryKey(String id);
  
	int insert(User record);

	int insertSelective(User record);
  
	 public User selectByPrimaryKey(String id);
     
	int updateByPrimaryKeySelective(User record);
  
	int updateByPrimaryKey(User record);
 
	List<User> getAll();
     int select();
	List<User> getAll2();

	List<User> getAll3();
	List<User> getAllPage(int pageNow, int row);
	List<User> getAllPage(PageTool aPageTool);
	List<User> likeSelect(PageTool aPageTool);
	List<User> likeSelect1(@Param("news")String news);
}