package com.highradius.connection;

import com.highradius.model.Invoice;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;

public class DatabaseConnection {
	// Connection connection = null;
	// Statement statement = null;
	// ResultSet resultSet = null;

	static String URL = "jdbc:mysql://localhost:3306/hrc";
	static String USER = "root";
	static String PASS = "Sagar@2000";
	ArrayList<Invoice> list = new ArrayList<Invoice>();

	// public ArrayList<Invoice> getInvoices(){
	// return list;
	// }
	// public void addInvoice(Invoice invoice) {
	// list.add(invoice);
	// }
	public static Connection connect() throws SQLException {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
