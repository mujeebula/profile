package com.profile;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class LoginDao {

	public String authenticateUser(LoginBean loginBean) {
		String userName = loginBean.getEmail();
		String password = loginBean.getPassword();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String emailDB = "";
		String passwordDB = "";
		try {
			con = (Connection) DBConnection.createConnection();
			statement = (Statement) con.createStatement();
			resultSet = (ResultSet) statement.executeQuery("select email,password from user");
			while (resultSet.next()) {
				emailDB = resultSet.getString("email");
				passwordDB = resultSet.getString("password");
				if (userName.equals(emailDB) && password.equals(passwordDB)) {
					return "SUCCESS";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}