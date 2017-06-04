package com;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AddDao;
import model.User;

public class LoginAction extends ActionSupport{
	private static String FORWARD=null;			//页面导向
	private String username;
	private String password;
	List<User> user_list=new ArrayList<User>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//重写validate 校验
	public void validate(){
		if(getUsername()==null||getUsername().trim().equals("")){
			//返回错误信息键值，userrequired包含messageResource.propertices
			//给一个字段（属性）添加错误信息
			addFieldError("username",getText("用户名必填"));
		}
		if(getPassword()==null||getPassword().trim().equals("")){
			addFieldError("password",getText("密码必填1"));
		}
	}
	public String execute() throws Exception{
		username=getUsername();
		password=getPassword();
		AddDao dao=new AddDao();
		try{
			if(username.equals("admin")&&password.equals("admin")){
				//到管理层页面
			
				user_list=(ArrayList<User>) dao.view();
				//System.out.println(user_list.size());
				  for (int i = 0; i < user_list.size(); i++) {
			            System.out.println(user_list.get(i).getUsername());
			            System.out.println(user_list.get(i).getPassword());
			            System.out.println("=============================");
			        }
				
				  ActionContext.getContext().put("list", user_list);
//				  ServletActionContext.getRequest().getSession().setAttribute("user", user_list);
				  FORWARD="manager";
			}
			else{
				//查找是否存在该名字
				
				User u=new User();
				u=dao.findName(username);
				//是，检查密码是否正确
					//不是
				if(u.getUsername()==null){
					ActionContext.getContext().put("message","不存在该用户");//${message }
					 FORWARD="false";
				}
				else{
					if(u.getPassword().equals(password)){
//						//获得值栈，存入值
						 ActionContext.getContext().put("message","登录成功");//${message }
					     ServletActionContext.getRequest().getSession().setAttribute("user", u);
					     FORWARD="user";
					}else{
						 ActionContext.getContext().put("message","登录失败");//${message }
						 FORWARD="false";
					}
					
				}
				
					
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return FORWARD;
	}
	  public List<User> getUser_list() {
	        return user_list;
	    }
	  public void setUser_list(List<User> user_list) {
	        this.user_list = user_list;
	    }
}
