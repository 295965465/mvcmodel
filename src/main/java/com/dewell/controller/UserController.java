package com.dewell.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import com.dewell.model.log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dewell.common.easyuitool.DataGrid;
import com.dewell.common.easyuitool.PageTool;
import com.dewell.model.User;
import com.dewell.service.UserServiceI;
import org.springframework.web.servlet.ModelAndView;

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

     @RequestMapping("/showLog.do")
	 @ResponseBody
	  public DataGrid showlog(){

		 try {
			 log aaa=  	 readFileByBytes("C:\\Users\\DELL\\Documents\\WeChat Files\\zhangsencheng\\Files\\LOG.txt");
			 List cc=new ArrayList<log>();
			 cc.add(aaa);
			 DataGrid dataGrid=new DataGrid();
			 dataGrid.setRows(cc);
			 dataGrid.setTotal(1);
			 return dataGrid;
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
         return  null;
	 }

	public static void main(String[] args) {
		try {
			log aaa=new UserController().readFileByBytes("C:\\Users\\DELL\\Documents\\WeChat Files\\zhangsencheng\\Files\\LOG.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public log  readFileByBytes(String fileName) throws  Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("HH:mm:ss");
		// 使用ArrayList来存储每行读取到的字符串
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			File file = new File(fileName);
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			// 按行读取字符串
			String str;
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对ArrayList中存储的字符串进行处理
		int length = arrayList.size();
		ArrayList<log> list=new ArrayList<>();
		for (int i =1; i < length-1; i++) {

				String s = arrayList.get(i);
				String[] array1 = s.split("\t");
				log a = new log();
				a.setDate(df.format(new Date()));
				a.setTime(df1.format(new Date()));
				a.setVmin(array1[2]);
				a.setVmax(array1[3]);
				a.setVout(array1[4]);
				a.setLout(array1[5]);
				a.setWout(array1[6]);
				a.setFreq(array1[7]);
				a.setCap(array1[8]);
				a.setVbat(array1[9]);
				a.setTupsC(array1[10]);
				a.setVaout(array1[11]);
				list.add(a);

		}
		int a1 =(int)(Math.random() * 24)+1;
		System.out.println(a1+"aaaaaaa");

         return list.get(a1);

		// 返回数组





			}


	}

