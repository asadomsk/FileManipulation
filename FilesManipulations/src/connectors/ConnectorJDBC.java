package connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectorJDBC {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/FilesDB";

	// Database credentials
	static final String USER = "myuser";
	static final String PASS = "xxxx";

	public void insert(String operation, String source, String dest) {
		Connection conn = null;
		Statement stmt = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String sql = "INSERT INTO actions " + "VALUES (" + "'"+ operation + "',"+ "'" +source+ "'," + "'" + dest+ "'," + "'" + formatter.format(date) + "')";
			stmt.executeUpdate(sql);
			System.out.println("Inserted record into the table...");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}// end main

}
