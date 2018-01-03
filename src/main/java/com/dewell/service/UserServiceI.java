package com.dewell.service;

import java.util.List;

import com.dewell.common.easyuitool.PageTool;
import com.dewell.model.User;




public interface UserServiceI {
   /**
    * ͨ��id�õ��û�
    * @param id
    * @return
    */
	public User getUserById(String id);
    /**
     * �õ�ȫ�����û�
     * @return
     */
	List<User> getAll();
    public int addUser(String name,String pwd);//�����û�
    public int deletUser(String id);//ɾ���û�
	
	/**
	 * �����û�
	 * @param id
	 * @return
	 */
	public int updateUser(User record);
     int select();
	public List<User> getAllPage(PageTool aPageTool);
	public List<User> likeSelect(PageTool aPageTool);
	public List<User> likeSelect1(String news);
}
