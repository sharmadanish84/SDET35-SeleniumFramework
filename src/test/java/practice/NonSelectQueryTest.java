package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQueryTest {
public static void main(String[] args) throws Throwable {
	Connection conn = null;
	int result=0;
	
	
	try {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice" , "root" , "root");
		System.out.println("connection is done");
		Statement stat = conn.createStatement();
		String query = "insert into student values('13','1234566680')";
		result=stat.executeUpdate(query);
	} catch (SQLException e) {
	
	}
	finally {
		if (result==1) {
			System.out.println("project is inserted successfully");
			
		} else {
			System.out.println("project is not inserted");

		}
		conn.close();
		System.out.println("============close db connection==============");
	}
	
}
}
