package dao;

import java.sql.SQLException;
import java.util.List;

import entity.College;
import entity.Student;

public interface IDao {
	void insertDetails(Student s) throws ClassNotFoundException, SQLException;
	public College allotedCollege(String studentId) throws SQLException, ClassNotFoundException;
	List viewAllDetails() throws ClassNotFoundException, SQLException;
	List nearByLocation(String location) throws ClassNotFoundException, SQLException;
	List viewAllColleges() throws ClassNotFoundException, SQLException;
	

}
