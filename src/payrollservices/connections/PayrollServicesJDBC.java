package payrollservices.connections;

import java.sql.*;

public class PayrollServicesJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/payroll_service";
		final String userName = "root";
		final String password = "Lambop@12345";
		Connection connection = DriverManager.getConnection(url,userName,password);
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
		
		while(resultSet.next()) {
			String EmployeeName = resultSet.getString("EmployeeName");
			int NetPay = resultSet.getInt("NetPay");
			
			System.out.println("EMployeeName :: " + EmployeeName +'\n'+ "NetPay :: " + NetPay+'\n');
		}
		
		statement.close();
		connection.close();
		

	}

}
