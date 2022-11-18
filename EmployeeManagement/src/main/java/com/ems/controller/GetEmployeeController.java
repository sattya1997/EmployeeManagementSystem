package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import com.google.gson.Gson;

@javax.servlet.annotation.WebServlet("/getAllEmployee")
public class GetEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson gson = new Gson();
	EmployeeDAO employeeDAO = new EmployeeDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Employee> employees = employeeDAO.getAllEmployee();
	
		String json = this.gson.toJson(employees);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
	}
}
