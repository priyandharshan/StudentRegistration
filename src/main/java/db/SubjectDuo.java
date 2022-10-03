package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.Examination;
import com.Results;
import com.Subjects;

public class SubjectDuo {

	private static SubjectDuo subjectDuo = null;
//	Connection conn=null;

	private SubjectDuo() {

	}

	public static SubjectDuo getInstance() {
		if (subjectDuo == null) {
			subjectDuo = new SubjectDuo();
		}
		return subjectDuo;

	}

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/studentdb";
	private String username = "root";
	private String password = "root";

	private final static String INSERT_SUBJECT = "insert into subjects (subjectname,grade) values(?,?);";
	private final static String SELECT_SEBJECT = "select * from subjects;";
	private final static String SELECT_EXAM = "select * from examination;";
	private final static String INSERT_RESULTS = "insert into results(studentid,subjectid,examid,marks) values(?,?,?,?);";
	private final static String SELECT_RESULTS = "select * from results";
	private final static String SELECT_SUBJECT_GREDE = "select subjectname,grade from subjects;";
	private final static String DELETE_RESULTS = "delete from results where resultid=?";
	private final static String SEARCH_RESULTS = "select * from results where studentid=?;";
	private final static String SELECT_SUBJECT_FROM_ID = " select subjectname,grade from subjects where subjectid=?;";
	private final static String SELECT_RESULTS_FROM_ID = " select subjectid,examid,marks from results where studentid=?";

	private final static String SELECT_ALL_RESULTS = "select r.resultid,s.studentid,s.firstname,p.subjectname"
			+ ",p.grade,e.examname,r.marks from students  as s inner join results "
			+ "as r on r.studentid=s.studentid inner join subjects "
			+ "as p on p.subjectid=r.subjectid inner join examination as e on e.examid=r.examid";
	
	private final static String DELETE_FROM_SUBJECT=" delete from subjects where subjectid=?;";
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
//	public List<Objects> getAllResults(){
//		
//		ArrayList<Objects> list=new ArrayList<Objects>();
//		
//		try {
//			Connection conn=getConnection();
//			
//			PreparedStatement pst=conn.prepareStatement(SELECT_ALL_RESULTS);
//			ResultSet rs=pst.executeQuery();
//			
//			while(rs.next())
//			{
//				int resultId=rs.getInt(1);
//				int studentId=rs.getInt(2);
//				String fName=rs.getString(3);
//				String subjectName=rs.getString(4);
//				String grade=rs.getString(5);
//				String exam=rs.getString(6);
//				int marks=rs.getInt(7);
//				
//				list.add(new Objects(resultId,studentId,fName,subjectName,grade,exam,marks));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}

	public Subjects selectSubject(int id) {
		Subjects subject = null;
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(SELECT_SUBJECT_FROM_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String subName = rs.getString(1);
				String grade = rs.getString(2);
				subject = new Subjects(subName, grade);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}

	public List<Results> selectProfileResult(int id) {
		ArrayList<Results> list = new ArrayList<Results>();

		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(SELECT_RESULTS_FROM_ID);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				
				int subId = rs.getInt(1);
				String exId = rs.getString(2);
				int marks = rs.getInt(3);

				list.add(new Results( subId, exId, marks));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Results> searchResults(int studentId) {
		ArrayList<Results> list = new ArrayList<Results>();
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(SEARCH_RESULTS);

			pst.setInt(1, studentId);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int resultId = rs.getInt(1);
				int stuid = rs.getInt(2);
				int subId = rs.getInt(3);
				String exId = rs.getString(4);
				int marks = rs.getInt(5);

				list.add(new Results(resultId, stuid, subId, exId, marks));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteResults(int id) {
		boolean status = false;
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(DELETE_RESULTS);
			pst.setInt(1, id);
			status = pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean alredyExits(String subjectName, String grade)

	{
		boolean status = false;
		try {
			Connection conn = getConnection();

			PreparedStatement pst = conn.prepareStatement(SELECT_SUBJECT_GREDE);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (subjectName.equals(rs.getString(1)) && grade.equals(rs.getString(2))) {
					status = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	public List<Results> selectALLResults() {
		ArrayList<Results> resultList = new ArrayList<Results>();
		ResultSet rs = null;
		try {
			Connection conn = getConnection();

			PreparedStatement pst = conn.prepareStatement(SELECT_RESULTS);
			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int studentid = rs.getInt(2);
				int subjectid = rs.getInt(3);
				String examid = rs.getString(4);
				int mark = rs.getInt(5);
				resultList.add(new Results(id, studentid, subjectid, examid, mark));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	public boolean insertResults(Results results) {
		boolean status = false;

		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(INSERT_RESULTS);
			pst.setInt(1, results.getStudentId());
			pst.setInt(2, results.getSubjectId());
			pst.setString(3, results.getExamId());
			pst.setInt(4, results.getStudentMark());
			pst.execute();
			status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<Examination> selectAllExam() {
		ArrayList<Examination> examList = new ArrayList<Examination>();
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(SELECT_EXAM);
			rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String examName = rs.getString(2);
				examList.add(new Examination(id, examName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return examList;
	}

	public List<Subjects> selectAllSubjects() {
		ArrayList<Subjects> subjectList = new ArrayList<Subjects>();
		ResultSet rs = null;
		try {
			Connection conn = getConnection();

			PreparedStatement st = conn.prepareStatement(SELECT_SEBJECT);
			rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String subName = rs.getString(2);
				String grade = rs.getString(3);

				subjectList.add(new Subjects(id, subName, grade));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectList;
	}

	public boolean insertSubject(Subjects subject)

	{
		boolean status = false;

		try {
			Connection conn = getConnection();

			PreparedStatement st = conn.prepareStatement(INSERT_SUBJECT);

			st.setString(1, subject.getSubjectName());
			st.setString(2, subject.getGrade());

			status = st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	public boolean deleteSubject(int id)
	{
		boolean status=false;
		
		try {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement(DELETE_FROM_SUBJECT);
			pst.setInt(1, id);
			pst.execute();
			status=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
