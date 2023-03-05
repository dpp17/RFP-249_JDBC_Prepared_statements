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
		String query = "insert into employee_payroll(EmployeeName, NetPay, StartDate, City, Country, Address, Department, BasicPay, Deductions, TaxablePay, Tax) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(2, employeePojo.getNetPay());
//		statement.setLong(7, employeePojo.getPhoneNumber());
		statement.setInt(8, employeePojo.getBasicPay());
		statement.setInt(10, employeePojo.getTaxAblePay());
		statement.setInt(9, employeePojo.getDeductions());
		statement.setInt(11, employeePojo.getTax());
		statement.setString(1, employeePojo.getEmployeeName());
//		statement.set(2, employeePojo.getGender());
		statement.setString(3, employeePojo.getStartDate());
		statement.setString(7, employeePojo.getDepartment());
		statement.setString(5, employeePojo.getCountry());
		statement.setString(4, employeePojo.getCity());
		statement.setString(6, employeePojo.getAddress());

		int res = statement.executeUpdate();
		System.out.println(res+" :: records inserted");
		
		statement.close();
		connection.close();
		

	}

}
