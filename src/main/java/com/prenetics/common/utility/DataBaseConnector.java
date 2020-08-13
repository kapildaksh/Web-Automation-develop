package com.prenetics.common.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseConnector {

	private static String dbusername;
	private static String dbpassword;

	public static String executeSQLQuery(String sqlQuery, String connectionURL)
			throws SQLException, ClassNotFoundException {

		dbusername = "dbtest";
		dbpassword = "fnEJ3MEPWsWXp";

		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(connectionURL, dbusername, dbpassword);
		if (connection != null) {
			System.out.println("Connected to the database...");
		} else {
			System.out.println("Database connection failed to Environment");
		}
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sqlQuery);
		rs.next();
		String resultValue = rs.getString(1).toString();
		connection.close();
		return resultValue;
	}

	public static ArrayList<String> executeSQLQuery_List(String testEnv, String sqlQuery, String connectionURL)
			throws ClassNotFoundException, SQLException {
		ArrayList<String> resultValue = new ArrayList<String>();
		ResultSet resultSet;
		if (testEnv.equalsIgnoreCase("QA")) {
			dbusername = "dbtest";
			dbpassword = "fnEJ3MEPWsWXp";
		}
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(connectionURL, dbusername, dbpassword);
		if (connection != null) {
			System.out.println("Connected to the database");
		} else {
			System.out.println("Failed to connect to " + testEnv + " database");
		}
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery(sqlQuery);
		while (resultSet.next()) {
			int columnCount = resultSet.getMetaData().getColumnCount();
			StringBuilder stringBuilder = new StringBuilder();
			for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
				stringBuilder.append(resultSet.getString(iCounter).trim() + " ");
			}
			String reqValue = stringBuilder.substring(0, stringBuilder.length() - 1);
			resultValue.add(reqValue);
		}
		return resultValue;
	}
	
	public static void executeSQLQueryToInsert(String sqlQuery, String connectionURL)
			throws SQLException, ClassNotFoundException {

		dbusername = "dbtest";
		dbpassword = "fnEJ3MEPWsWXp";

		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(connectionURL, dbusername, dbpassword);
		if (connection != null) {
			System.out.println("Connected to the database...");
		} else {
			System.out.println("Database connection failed to Environment");
		}
		Statement stmt = connection.createStatement();
		stmt.execute(sqlQuery);
		
		connection.close();
		
	}

}