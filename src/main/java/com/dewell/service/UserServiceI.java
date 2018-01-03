package com.dewell.service;

import java.util.List;

import com.dewell.common.easyuitool.PageTool;
import com.dewell.model.User;




public interface UserServiceI {
   /**
    * 通过id得到用户
    * @param id
    * @return
    */
	public User getUserById(String id);
    /**
     * 得到全部的用户
     * @return
     */
	List<User> getAll();
    public int addUser(String name,String pwd);//增加用户
    public int deletUser(String id);//删除用户
	
	/**
	 * 更新用户
	 * @param id
	 * @return
	 */
	public int updateUser(User record);
     int select();
	public List<User> getAllPage(PageTool aPageTool);
	public List<User> likeSelect(PageTool aPageTool);
	public List<User> likeSelect1(String news);
}
