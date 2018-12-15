package client;

import java.sql.SQLException;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import entity.College;
import entity.Student;
import exception.StudentException;
import service.IService;
import service.ServiceImpl;

public class MainStudentJoining {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("WELCOME TO STUDENT JOINING");
		System.out.println("1.REGISTER");
		System.out.println("2.Check alloted college");
		System.out.println("3.VIEW ALL StudentDetails");
		System.out.println("4.CHECK NEAR BY COLLEGESS");
		System.out.println("5.VIEW ALL COLLEGES");
		System.out.println("6.EXIT");
		System.out.println("choose your option:");
		int option=sc.nextInt();
		switch(option) {
		case 1:
			Student s=new Student();
		
		System.out.println("enter your name:");
		String name=sc.next();
		s.setSname(name);
		System.out.println("enter your mailid:");
		String mail=sc.next();
		s.setSmail(mail);
		System.out.println("enter your marks:");
		int marks=sc.nextInt();
		s.setSmarks(marks);
		System.out.println("enter your location");
		String location=sc.next();
		s.setSlocation(location);
		ServiceImpl serviceimpl=new ServiceImpl();
			try {
				serviceimpl.validateStudent(s);
				
				
				try {
					serviceimpl.insertDetails(s);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (StudentException e) {
				System.out.println(e);
			}
		
			
				
			
		break;
		case 2:
	
			ServiceImpl serviceImpl=new ServiceImpl();
			College college1=null;
			String studentId = null;
			System.out.println("enter student id to check allotted college ......");
			studentId=sc.next();
			
			if(serviceImpl.isValidId(studentId)) {
			try {
				college1 = serviceImpl.allotedCollege(studentId);
				System.out.println("Allotted college  is : "+college1);
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
			
			}
			break;
		case 3:
			ServiceImpl serviceimpl1=new ServiceImpl();
			try {
				serviceimpl1.viewAllDetails();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
	       			e.printStackTrace();
			}
			
			System.out.println(	serviceimpl1.viewAllDetails());
		
			
			break;
		case 4:
			College college=new College();
			System.out.println("Enter your location:");
			String location1=sc.next();
			ServiceImpl serviceImpl1=new ServiceImpl();
			System.out.println(serviceImpl1.nearByLocation(location1));
			
		break;	
		case 5:
			ServiceImpl serviceImpl2=new ServiceImpl();
			
			System.out.println(serviceImpl2.viewAllColleges());
		break;
		case 6:
			System.out.println("thank you");
			System.exit(0);
			
		break;
		}
}

}


