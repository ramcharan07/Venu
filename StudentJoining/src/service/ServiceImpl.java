package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DaoImpl;
import dao.IDao;
import exception.StudentException;
import entity.College;
import entity.Student;

public class ServiceImpl implements IService{

	
	static IDao dao=new DaoImpl();
	public void validateStudent(Student student) throws StudentException
	{
		List validationErrors = new ArrayList();

		//Validating donor name
		if(!(isValidsname(student.getSname()))) {
			validationErrors.add("\n Student Name Should Be  minimum 3 characters long ! \n");
		}
		if(!(isValidsmail(student.getSmail()))){
			validationErrors.add("\n mail  \n");
		}
		//Validating marks
		if(!(isValidsmarks(student.getSmarks()))){
			validationErrors.add("\n marks should be more than 60 percent");
		}
		//Validating location
		if(!(isValidslocation(student.getSlocation()))){
			validationErrors.add("\n location shoud be more than 3 characters \n" );
		}
		
		if(!validationErrors.isEmpty()) {
			throw new StudentException(validationErrors +"");
		}
	}
	
	public boolean isValidsname(String sname) {
		Pattern namepattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher namematcher=namepattern.matcher(sname);
		return namematcher.matches() ;
		
	}
	public boolean isValidsmail(String smail) {
		Pattern mailpattern=Pattern.compile("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+).([a-zA-Z]{2,5})$");
		Matcher mailmatcher=mailpattern.matcher(smail);
		return mailmatcher.matches() ;
	}
	public boolean isValidsmarks(int smarks) {
		
		Pattern markspattern=Pattern.compile("^[0-9]*$");
		Matcher marksmatcher=markspattern.matcher(Integer.toString(smarks));
		return marksmatcher.matches() ;
	}
	public boolean isValidslocation(String slocation) {
		Pattern locationpattern=Pattern.compile("[A-Za-z]{2,}$");
		Matcher locationmatcher=locationpattern.matcher(slocation);
		return locationmatcher.matches() ;
	}
	
	public boolean isValidId(String studentId) {

		String nameRegEx = "[1-9][0-9]{2,3}$";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(studentId);
		return matcher.matches();
		
	}

	@Override
	public void insertDetails(Student s) throws ClassNotFoundException, SQLException {
		dao.insertDetails(s);
		
	}

	@Override
	public College allotedCollege(String studentId) throws SQLException, ClassNotFoundException {
	College college=new College();
		college=dao.allotedCollege(studentId);
		return college;
	}

	@Override
	public List viewAllDetails() throws ClassNotFoundException, SQLException {
		List<Student> list=new ArrayList<>();
		list=dao.viewAllDetails();
		return list;
	}

	@Override
	public List nearByLocation(String location) throws ClassNotFoundException, SQLException {
		
		List<College> list=new ArrayList<>();
		list=dao.nearByLocation(location);
		return list;
	}

	@Override
	public List viewAllColleges() throws ClassNotFoundException, SQLException {
		List<College> list=new ArrayList<>();
		list=dao.viewAllColleges();
		return list;
	
	}

	
	
	
	
	
	
	

}
