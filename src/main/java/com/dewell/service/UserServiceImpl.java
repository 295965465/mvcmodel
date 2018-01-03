package com.dewell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import com.dewell.common.easyuitool.PageTool;
import com.dewell.dao.UserMapper;
import com.dewell.model.User;


@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private UserMapper userMapper;
	/**
	 * ͨ��idȥ��ѯ
	 */
	public User getUserById(String id) {
		User user=null;
		try {
			user = this.userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ȫ��ѯ
	 */
	public List<User> getAll() {
		List<User> list = this.userMapper.getAll();
		return list;
	}

	public List<User> getAll2() {
		return userMapper.getAll2();
	}

	public List<User> getAll3() {
		return userMapper.getAll3();
	}

	/**
	 * ����û�?
	 */
	public int addUser(String name, String pwd) {
		User record = new User();
		record.setName(name);
		record.setPwd(pwd);
		int num = this.userMapper.insert(record);
		return num;
	}

	/**
	 * ɾ���û�
	 */
	public int deletUser(String id) {
		int num = this.userMapper.deleteByPrimaryKey(id);
		return num;
	}

	/**
	 * ����Ǹ���?
	 */
	public int updateUser(User record) {
		int num = this.userMapper.updateByPrimaryKey(record);
		return num;
	}

	public int select() {
		int num=this.userMapper.select();
		return num;
	}

	public List<User> getAllPage(PageTool aPageTool) {
		List<User> list = this.userMapper.getAllPage(aPageTool);
		return list;
	}

	public List<User>  likeSelect(PageTool aPageTool) {
		List<User> list=this.userMapper.likeSelect(aPageTool);
		return list;
	}
	public List<User>  likeSelect1(String news) {
		List<User> list=this.userMapper.likeSelect1(news);
		return list;
	}


}
