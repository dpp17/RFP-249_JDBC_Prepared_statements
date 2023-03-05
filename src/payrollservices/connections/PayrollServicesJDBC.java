package payrollservices.connections;

import java.sql.*;

//import payrollservices.controller.EmployeePayroll;
//import payrollservices.model.EmployeePayrollPojo;

public class PayrollServicesJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		EmployeePayroll employeeObj = new EmployeePayroll();
//		EmployeePayrollPojo employeePojo = employeeObj.getDetails();
		
		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/payroll_service";
		final String userName = "root";
		final String password = "Lambop@12345";
		Connection connection = DriverManager.getConnection(url,userName,password);
		String query = "select * from employee_payroll where StartDate between cast('2015-01-01' as date) and date(now()); ";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			//int employeeID = resultSet.getInt("EmployeeID");
			String employeeName = resultSet.getString("EmployeeName");
			int netPay = resultSet.getInt("NetPay");
			String startDate = resultSet.getString("StartDate");
			String city = resultSet.getString("City");
			String country = resultSet.getString("Country");
			String address = resultSet.getString("Address");
			String department = resultSet.getString("Department");
			int basicPay = resultSet.getInt("BasicPay");
			int deductions = resultSet.getInt("Deductions");
			int taxAblePay = resultSet.getInt("TaxablePay");
			int tax = resultSet.getInt("Tax");
			
			System.out.println("employeeID=" + ", employeeName=" + employeeName
				+ ", netPay=" + netPay + ", startDate=" + startDate + ", city=" + city + ", country=" + country
				+ ", address=" + address + ", department=" + department + ", basicPay="
				+ basicPay + ", deductions=" + deductions + ", taxAblePay=" + taxAblePay + ", tax=" + tax);
			
		}
		
//		PreparedStatement statement = connection.prepareStatement(query);
//		statement.setInt(1, employeePojo.getNetPay());
//		statement.setString(2, employeePojo.getEmployeeName());
		//int res = statement.executeUpdate();
		//System.out.println(res+" :: records inserted");
		
		statement.close();
		connection.close();
		

	}

}
