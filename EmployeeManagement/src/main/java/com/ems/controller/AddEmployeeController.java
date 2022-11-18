package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import com.google.gson.Gson;

@javax.servlet.annotation.WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDAO employeeDAO = new EmployeeDAO();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = this.gson.fromJson(request.getReader(), Employee.class);
		int result = employeeDAO.addEmployee(employee);
		
		PrintWriter out = response.getWriter();
		
		if (result == 1) {
			String json = this.gson.toJson(employee);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			out.print(0);
			out.flush();
		}
	}
}
