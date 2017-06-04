package com;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AddDao;
import model.User;

public class LoginAction extends ActionSupport{
	private static String FORWARD=null;			//ҳ�浼��
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
	//��дvalidate У��
	public void validate(){
		if(getUsername()==null||getUsername().trim().equals("")){
			//���ش�����Ϣ��ֵ��userrequired����messageResource.propertices
			//��һ���ֶΣ����ԣ���Ӵ�����Ϣ
			addFieldError("username",getText("�û�������"));
		}
		if(getPassword()==null||getPassword().trim().equals("")){
			addFieldError("password",getText("�������1"));
		}
	}
	public String execute() throws Exception{
		username=getUsername();
		password=getPassword();
		AddDao dao=new AddDao();
		try{
			if(username.equals("admin")&&password.equals("admin")){
				//�������ҳ��
			
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
				//�����Ƿ���ڸ�����
				
				User u=new User();
				u=dao.findName(username);
				//�ǣ���������Ƿ���ȷ
					//����
				if(u.getUsername()==null){
					ActionContext.getContext().put("message","�����ڸ��û�");//${message }
					 FORWARD="false";
				}
				else{
					if(u.getPassword().equals(password)){
//						//���ֵջ������ֵ
						 ActionContext.getContext().put("message","��¼�ɹ�");//${message }
					     ServletActionContext.getRequest().getSession().setAttribute("user", u);
					     FORWARD="user";
					}else{
						 ActionContext.getContext().put("message","��¼ʧ��");//${message }
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
