package dao;

import java.util.List;

import model.Student;

public class TestConnection {
	public static void main(String[] args) {
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		//studentDAOImpl.createStudent(new Student (1L,"Ramon","GSIVBN","Vespertino"));
		//List<Student> students = studentDAOImpl.readAllStudents(); 
		//	System.out.println(students);
		studentDAOImpl.deleteStudent(0L);
		//studentDAOImpl.createStudent(new Student (1L, "Ramon","GSIVBN","Vespertino"));
		}
}
