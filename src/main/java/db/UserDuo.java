package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Users;


public class UserDuo {
	
//	private final static String GET_USERID="select (max)userid from users;";
	private final static String INSERT_USERS="insert into users (username,email,password) values(?,?,?) ";
	private final static String SELECT_EMAIL="select email from users";
	private final static String SELECT_EMAIL_PASSWORD=" select email,password from users";
	StudentDb studentDb=StudentDb.getInstance();
	
	public boolean alreadyExitsEmail(String email)
	{
		boolean status=false;
		try {
			Connection conn=studentDb.getConnection();
			PreparedStatement pst=conn.prepareStatement(SELECT_EMAIL);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				if(email.equalsIgnoreCase(rs.getString(1)))
				{
					status=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean insertUsers(Users user)
	{
		boolean status=false;
		try {
			Connection conn=studentDb.getConnection();
			PreparedStatement pst=conn.prepareStatement(INSERT_USERS);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.execute();
			status=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean checkUsers(String email,String password)
	{
		boolean status=false;
		try {
			Connection conn=studentDb.getConnection();
			PreparedStatement pst=conn.prepareStatement(SELECT_EMAIL_PASSWORD);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				if(email.equalsIgnoreCase(rs.getString(1)) && password.equalsIgnoreCase(rs.getString(2)))
				{
					status=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
