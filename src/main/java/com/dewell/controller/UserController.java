package com.dewell.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dewell.common.easyuitool.DataGrid;
import com.dewell.common.easyuitool.PageTool;
import com.dewell.model.User;
import com.dewell.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {
	
		private static final String SUCCESS = "showUser";
		private static final String ERROR = "MyJsp";
		@Autowired
		private UserServiceI userServiceI;
		
		@RequestMapping("/showUser.do")
		public String showUser(String id, Map<String, Object> map) {
			System.out.println(id + "11111");
			User user = this.userServiceI.getUserById(id);
			if (user != null) {
				map.put("user", user);
				return SUCCESS;
			}
			return ERROR;
		}

		@RequestMapping("/showAllUser.do")
		@ResponseBody
		public DataGrid showAllUser(int page,int rows) {
			 
			List<User> list1 = this.userServiceI.getAll();
			//寰楀埌鎬昏鏁�
			int recordCount=list1.size();
			PageTool aPageTool=new PageTool(rows, page);
			System.out.println(aPageTool+"aaaaaaaaaaaaaaaaa");
			List<User> list = this.userServiceI.getAllPage(aPageTool);
			
			DataGrid dataGrid=new DataGrid();
			dataGrid.setRows(list);
			dataGrid.setTotal(recordCount);
			return dataGrid;
		}

		@RequestMapping("/addUser.do")
		public String addUser(String username, String userpwd) {
			int num = this.userServiceI.addUser(username, userpwd);
			return SUCCESS;
		}

		@RequestMapping("/updateUser.do")
		public String updateUser(User user, String id1, HttpServletRequest request,String username,String userpwd ,String userid) {
			if (id1!=null) {
				
			User byuser = this.userServiceI.getUserById(id1);
			request.getSession().setAttribute("byuser", byuser);
			return "update";	
			}
			user.setName(username);
			user.setPwd(userpwd);
			user.setId(userid);
			int num = this.userServiceI.updateUser(user);
			return SUCCESS;
		}
	      
		@RequestMapping("/deletUser.do")
		public String deletUser(String id) {
			int num = this.userServiceI.deletUser(id);
			return SUCCESS;
		}
		/**
		 * 妯＄硦鏌ヨ
		 * @param news
		 * @param page
		 * @param rows
		 * @return
		 */
		@RequestMapping("/likeSelect.do")
		@ResponseBody
		public DataGrid likeSelect(String news,int page,int rows) {
			List<User> list1 = this.userServiceI.likeSelect1(news);
			int recordCount=list1.size();
			PageTool aPageTool=new PageTool(rows, page,news);
			List<User> num = this.userServiceI.likeSelect(aPageTool);
			DataGrid dataGrid=new DataGrid();
			dataGrid.setRows(num);
			dataGrid.setTotal(recordCount);
			return dataGrid;
		}
		/**
		 * 鎵归噺鍒犻櫎
		 * @param ids
		 * @return
		 */
		@RequestMapping("/batchDelete.do")
		public String batchDelete(int[] ids){
			for (int i : ids) {
				String b=i+"";
				int num=this.userServiceI.deletUser(i+"");
			}
			return SUCCESS;
		}
	}

