package db;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.Students;
import com.Users;

public class StudentDb {

	private static StudentDb studentDb = null;
//	Connection conn=null;

	private StudentDb() {

	}

	public static StudentDb getInstance() {
		if (studentDb == null) {
			studentDb = new StudentDb();
		}
		return studentDb;

	}

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/studentdb";
	private String username = "root";
	private String password = "root";

	private final static String SELECT_USER = "Select *from student;";
	private final static String INSERT_USER = "insert into student(firstname,lastname,address,phone,dateofbirth,grade,gender,photo) values(?,?,?,?,?,?,?,?);";
	private final static String UPDATE_USER = "update student set firstname = ?,lastname= ?, address =?, phone=?,dateofbirth=?, grade=?,gender=?,photo=? where studentid = ?;";
	private final static String DELETE_USER = "delete from student where studentid=?;";
	private final static String SELECT_STUDENT="select firstname,lastname,address,phone,dateofbirth from student where studentid=?;";
	private final static String SELECT_FNAME_LNAME="select studentid,firstname,lastname from student";
	private final static String SELECT_ALL_PROFILE=" select * from student where studentid=?;";
	
	
	public Connection getConnection() throws SQLException {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;
	}
	
	

	public List<Students> selectFirstLastName()
	{
		ArrayList<Students> list=new ArrayList<Students>();
		
		try {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement(SELECT_FNAME_LNAME);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String fName=rs.getString(2);
				String lName=rs.getString(3);
				
				list.add(new Students(id,fName,lName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean insertUser(Students student,InputStream inputStream) {

		boolean status = false;

		try {

			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(INSERT_USER);

			pst.setString(1, student.getFirstName());
			pst.setString(2, student.getLastName());
			pst.setString(3, student.getAddress());
			pst.setString(4, student.getPhonenumber());
			pst.setString(5, student.getDateOfBirth().toString());
			
//			int gradeid=selectGradeId(student.getGrade());
			pst.setString(6, student.getGrade());
			pst.setString(7, student.getGender());
//			InputStream inputStream =new ByteArrayInputStream(student.getImage());
			pst.setBlob(8,inputStream);
			pst.execute();
			status=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public List<Students> selectStudents() {
		ArrayList<Students> studentList = new ArrayList<Students>();

		ResultSet resultSet = null;

		try {
			Connection conn = getConnection();

			PreparedStatement pst = conn.prepareStatement(SELECT_USER);
			resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fname = resultSet.getString(2);
				String lname = resultSet.getString(3);
				String address = resultSet.getString(4);
				String phone = resultSet.getString(5);
				String dob = resultSet.getString(6);
				String grade = resultSet.getString(7);
				String gender = resultSet.getString(8);
				
				 Blob blob = resultSet.getBlob(9);
				 
				if(blob!=null)
				 {
		            byte byteArray[] = blob.getBytes(1, (int) blob.length());
		            String base64Image = Base64.getEncoder().encodeToString(byteArray); 
				 
		            
				
//				String grade=selectGrade(gradeid);

				studentList.add(new Students(id, fname, lname, address, phone, dob, grade, gender,base64Image));
				 }
				 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Students student,InputStream inputStream) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
			//System.out.println("updated USer:" + statement);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getAddress());
			statement.setString(4, student.getPhonenumber());
			statement.setString(5, student.getDateOfBirth().toString());
			
//			int gradeid=selectGradeId(student.getGrade());
			statement.setString(6, student.getGrade());
			statement.setString(7, student.getGender());
			statement.setBlob(8,inputStream);
			statement.setInt(9, student.getStudentId());
//			InputStream inputStream=new ByteArrayInputStream(student.getImage());
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	public Students selectAllProfile(int id)
	{
		Students student=null;
		try {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement(SELECT_ALL_PROFILE);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String address=rs.getString(4);
				String phone =rs.getString(5);
				String dob=rs.getString(6);
				String grade=rs.getString(7);
				String gender=rs.getString(8);
				 Blob blob = rs.getBlob(9);
				 
					if(blob!=null)
					 {
			            byte byteArray[] = blob.getBytes(1, (int) blob.length());
			            String base64Image = Base64.getEncoder().encodeToString(byteArray); 
				
				student=new Students(id,fname,lname,address,phone,dob,grade,gender,base64Image);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		
	}
	

	public Students selectStudent(int id) {
		
		Students student=null;
		try {
			Connection conn=getConnection();
			
			PreparedStatement statement=conn.prepareStatement(SELECT_STUDENT);
			
			statement.setInt(1, id);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next())
			{
				String fname=rs.getString(1);
				String lname=rs.getString(2);
				String address=rs.getString(3);
				String phone=rs.getString(4);
				String dob=rs.getString(5);
				
				student= new Students(id,fname,lname,address,phone,dob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	

	
}
