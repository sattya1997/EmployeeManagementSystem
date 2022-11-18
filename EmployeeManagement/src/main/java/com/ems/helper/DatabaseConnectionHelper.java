package com.ems.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionHelper {
	private static String driverName;
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			String fileLocation = "C:\\Users\\a865061\\Eclipse-EE_Workspace\\EmployeeManagement\\src\\main\\java\\com\\ems\\resource\\config.properties";

			FileInputStream fileData = new FileInputStream(fileLocation);
			Properties property = new Properties();
			property.load(fileData);
			fileData.close();
			driverName = property.getProperty("driverName");
			url = property.getProperty("url");
			username = property.getProperty("username");
			password = property.getProperty("password");

		} catch (IOException cause) {
			cause.printStackTrace();
		}

	}

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException | ClassNotFoundException cause) {
			cause.printStackTrace();
		}
		return null;
	}
}
