package jdbc_servlet_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentCRUD {

public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servket", "root","root");
		return connection;
	}
	
	public int signUp(Student student) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getStudent_name());
		preparedStatement.setString(3, student.getFather_name());
		preparedStatement.setString(4, student.getMother_name());
		preparedStatement.setString(5, student.getAddress());
		preparedStatement.setLong(6, student.getPhone());
		preparedStatement.setString(7, student.getEmail());
		preparedStatement.setString(8, student.getPassword());
		
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
	
	public String getStudent(String email) throws ClassNotFoundException, SQLException
	{
		Connection connection= getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		
		ResultSet resultset = preparedStatement.executeQuery();
		String password = null;
		while (resultset.next()) 
		{
			password = resultset.getString("password");	
		}
		connection.close();
		return password;
	}
}
