package com;


import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import dao.AddDao;
import model.User;
/*	1.����get,set����
 * 	2.����dao�࣬�����ݵ������ݿ�
 * ����jsp���������ݣ������Ƿ�ϸ񣬵������ݿ�
 * */
public class AddAction extends ActionSupport{
	private static String FORWARD=null;			//ҳ�浼��	
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
			System.out.println("ע��ɹ�");
//			System.out.println(this.user.getUsername());
//			System.out.println(u.getUsername());
//			System.out.println(u.getBirth());
			dao.add(this.user);
			FORWARD="success";
		}
		else{
			System.out.println("ע��ʧ��");
			FORWARD="input";
		}
		
		return FORWARD;
	}
}
