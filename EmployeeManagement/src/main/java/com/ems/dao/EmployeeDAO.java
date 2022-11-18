package com.ems.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ems.helper.DatabaseConnectionHelper;
import com.ems.model.Employee;

public class EmployeeDAO {

	public List<Employee> getAllEmployee() {

		try (Connection connection = DatabaseConnectionHelper.getConnection()) {
			PreparedStatement statementForFetchEmployee = connection
					.prepareStatement("SELECT * FROM sample_db_employeemanagement.employee;");
			ResultSet employeeDetails = statementForFetchEmployee.executeQuery();

			List<Employee> employees = new ArrayList<>();

			while (employeeDetails.next()) {
				Employee employee = new Employee(employeeDetails.getInt(1), employeeDetails.getString(2),
						employeeDetails.getString(3), employeeDetails.getInt(4), employeeDetails.getString(5));
				employees.add(employee);
			}
			employeeDetails.close();
			statementForFetchEmployee.close();
			return employees;
		} catch (SQLException cause) {
			cause.printStackTrace();
		}
		return null;
	}

	public int addEmployee(Employee employee) {
		LocalDate date = LocalDate.now();
		employee.setDOJ(date.toString());
		try (Connection connection = DatabaseConnectionHelper.getConnection()) {
			PreparedStatement statementForCheckEmployee = connection.prepareStatement(
					"SELECT * FROM sample_db_employeemanagement.employee\r\n" + "WHERE employee.eid=?;");
			statementForCheckEmployee.setInt(1, employee.getEid());
			ResultSet checkEmployeeResult = statementForCheckEmployee.executeQuery();
			checkEmployeeResult.next();
			String result = checkEmployeeResult.getString(5);
			
			if(result==null) {
				PreparedStatement statementForAddEmployee = connection
						.prepareStatement("UPDATE `sample_db_employeemanagement`.`employee`\r\n" + "SET\r\n"
								+ "`doj` = ?,\r\n" + "`yoe` = ?,\r\n" + "`designation` = ?\r\n" + "WHERE `eid` = ?;");
				statementForAddEmployee.setString(1, employee.getDOJ());
				statementForAddEmployee.setInt(2, employee.getYoe());
				statementForAddEmployee.setString(3, employee.getDesignation());
				statementForAddEmployee.setInt(4, employee.getEid());
				int addemployeeResult = statementForAddEmployee.executeUpdate();
				statementForAddEmployee.close();
				return addemployeeResult;
			}
		} catch (SQLException cause) {
			cause.printStackTrace();
		}
		return 0;
	}
}
