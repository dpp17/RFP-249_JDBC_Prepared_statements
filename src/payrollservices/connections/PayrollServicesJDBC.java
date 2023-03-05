package payrollservices.connections;

import java.sql.*;

import payrollservices.controller.EmployeePayroll;
import payrollservices.model.EmployeePayrollPojo;

public class PayrollServicesJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeePayroll employeeObj = new EmployeePayroll();
		EmployeePayrollPojo employeePojo = employeeObj.getDetails();
		
		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/payroll_service";
		final String userName = "root";
		final String password = "Lambop@12345";
		Connection connection = DriverManager.getConnection(url,userName,password);
		String query = "update employee_payroll set NetPay = ? where EmployeeName = ?;";
		
		//Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, employeePojo.getNetPay());
		statement.setString(2, employeePojo.getEmployeeName());
		

		int res = statement.executeUpdate();
		System.out.println(res+" :: records inserted");
		
		statement.close();
		connection.close();
		

	}

}
