package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class AddDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/struts2";
	public AddDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 添加
	 * username string 姓名
	 * password String 密码
	 * address string 地址
	 * email string 邮箱
	 * birth date 生日
	 */
	public void add(User user){
		String sql="INSERT INTO user(username,password,address,email,birth) VALUES ( ?, ?, ?, ? ,?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setString(1, user.getUsername());
			cmd.setString(2, user.getPassword());
			cmd.setString(3, user.getAddress());
			cmd.setString(4, user.getEmail());
			cmd.setDate(5, new java.sql.Date(user.getBirth().getTime()));
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	显示所有学生
	public List<User> view(){
		ArrayList<User> list=new ArrayList<User>();
		String sql="select * from user";
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				User student =new User(res.getString(2), res.getString(3), res.getString(4),res.getString(5),res.getDate(6));
				list.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//查找姓名
	public User findName(String username){
			User u=new User();
			try{
				String sql="select * from user where username=?";
				PreparedStatement cmd=con.prepareStatement(sql);
				cmd.setString(1,username);
				ResultSet result = cmd.executeQuery();
				if(result.next()){
					u.setUsername(result.getString(2));
					u.setPassword(result.getString(3));
					u.setAddress(result.getString(4));
					u.setEmail(result.getString(5));
//					u.setBirth(result.getDate(6));
					u.setBirth(result.getDate(6));
				}
			}
			catch(Exception ex){
				System.out.println(ex.toString());
			}finally{
				return u;
			}
		}
	public static void main(String args[]){
		AddDao dao=new AddDao();
		//dao.add(user, password, address, email, birth);
//		dao.add("小佳","293741", "c8", "630993632@qq.com","1997-01-06");
		ArrayList<User> user_list=new ArrayList<User>();
		user_list=(ArrayList<User>) dao.view();
		for(User u:user_list){
			System.out.println(u.getUsername());
			System.out.println(u.getPassword());
			System.out.println(u.getAddress());
			System.out.println(u.getEmail());
			System.out.println(u.getBirth());
		}
//		User use=new User();
//		use=dao.findName("小");
//		System.out.println(use.getUsername());
//		System.out.println(use.getPassword());

	}
}
