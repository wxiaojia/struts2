package com;


import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import dao.AddDao;
import model.User;
/*	1.导入get,set方法
 * 	2.导入dao类，将数据导入数据库
 * 接受jsp传来的数据，检验是否合格，导入数据库
 * */
public class AddAction extends ActionSupport{
	private static String FORWARD=null;			//页面导向	
	 private User user =new User();
	    //private User user; 
	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	public String execute() throws Exception{
		AddDao dao=new AddDao();
		User u=new User();
		u=dao.findName(this.user.getUsername());

		if(u.getUsername()==null){
			System.out.println("注册成功");
//			System.out.println(this.user.getUsername());
//			System.out.println(u.getUsername());
//			System.out.println(u.getBirth());
			dao.add(this.user);
			FORWARD="success";
		}
		else{
			System.out.println("注册失败");
			FORWARD="input";
		}
		
		return FORWARD;
	}
}
