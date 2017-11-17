package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public StudentDAOImpl() {
		getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/testdb",
			"postgres",
			"utng");
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createStudent(Student student) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement
						("INSERT INTO students (name,group_student,turn) VALUES (?,?,?);");
				preparedStatement.setString(1, student.getName());
				preparedStatement.setString(2, student.getStudentGroup());
				preparedStatement.setString(3, student.getTurn());
				preparedStatement.execute();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Student readStudent(Long id) {
		Student student = null;
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement
						("SELECT * FROM students WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					student = new Student(
							resultSet.getLong(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4));				
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public List<Student> readAllStudents() {
		List<Student> students = new ArrayList<Student>();
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement
						("SELECT * FROM students;");
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Student student = new Student(
							resultSet.getLong(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4));
					students.add(student);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

	@Override
	public void updateStudent(Student student) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement
						("UPDATE students set name = ?, set group_student = ?, set turn = ? WHERE id = ?;");
				preparedStatement.setString(1, student.getName());
				preparedStatement.setString(2, student.getStudentGroup());
				preparedStatement.setString(3, student.getTurn());
				preparedStatement.setLong(4, student.getId());
				preparedStatement.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void deleteStudent(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement
						("DELETE FROM students WHERE id = ?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

}
