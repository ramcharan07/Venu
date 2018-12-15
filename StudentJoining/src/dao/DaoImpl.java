package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import DB.DBConnection;
import entity.College;
import entity.Student;
import java.sql.*;

public class DaoImpl implements IDao{
	DBConnection db=new DBConnection();

	@Override
	public void insertDetails(Student s) throws ClassNotFoundException, SQLException {
		int rs=0;
		Connection conn=db.getconnection();
		Statement st=conn.createStatement();
		PreparedStatement psmt=conn.prepareStatement("insert into StudentJoining values(Student_Sequence.nextval,?,?,?,?)");
		psmt.setString(1,s.getSname());
		psmt.setString(2,s.getSmail());
		psmt.setInt(3,s.getSmarks());
		psmt.setString(4,s.getSlocation());
		rs=psmt.executeUpdate();
		if(rs!=0) {
			System.out.println("sucess");
		}
		
	}
	
	@Override
	public College allotedCollege(String studentId) throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		int sid =Integer.parseInt(studentId);
		College college=null;
		try
		{
		Connection conn=db.getconnection();
		Statement st=conn.createStatement();
		rs = st.executeQuery("select b.cid,b.cname,b.clocation,b.cmarks from StudentJoining a, College b where a.sid="+sid+" and a.smarks>=b.cmarks order by cmarks desc");
		//System.out.println(rs.next());
		while(rs.next())
		{
			college = new College();
			college.setcId(rs.getInt(1));
			college.setCname(rs.getString(2));
			college.setClocation(rs.getString(3));
			college.setCmarks(rs.getString(4));
			//college;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return college;
		
	}

	

	@Override
	public List viewAllDetails() throws ClassNotFoundException, SQLException {
	
		List<Student> list=new ArrayList<Student>();
		Connection conn=db.getconnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from StudentJoining");
		while(rs.next()) {
			Student student=new Student();
			student.setsId(rs.getInt(1));
			student.setSname(rs.getString(2));
			student.setSmail(rs.getString(3));
			student.setSlocation(rs.getString(4));
			list.add(student);
		}
		return list;

		
		
	}

	@Override
	public List nearByLocation(String location) throws ClassNotFoundException, SQLException {
		
		List<College> list=new ArrayList<College>();
		Connection conn=db.getconnection();
		PreparedStatement psmt=conn.prepareStatement("select * from college where clocation=?");
		psmt.setString(1,location);
		ResultSet rs=psmt.executeQuery();
	while(rs.next()) {
		College college=new College();
		college.setcId(rs.getInt(1));
		college.setCname(rs.getString(2));
		college.setClocation(rs.getString(3));
		list.add(college);
	}
	return list;

	}

	@Override
	public List viewAllColleges() throws ClassNotFoundException, SQLException {
		List<College> list=new ArrayList<College>();
		Connection conn=db.getconnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from college");
		while(rs.next()) {
			College college=new College();
			college.setcId(rs.getInt(1));
			college.setCname(rs.getString(2));
			college.setClocation(rs.getString(3));
			list.add(college);
		}
		return list;
		
	}

	
	
	
	
	

}
