package com.profile;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class UserDao {

	public UserBean getUser(String email) {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String firstName, middleName, lastName, accountType, gender, dateOfBirth, profileUrl;
		boolean isActive;
		try {
			con = (Connection) DBConnection.createConnection();
			statement = (PreparedStatement) con.prepareStatement("select first_name, middle_name, last_name, email, "
					+ "account_type, gender, date_of_birth, profile_url, active from user where email=?");
			statement.setString(1, email);
			resultSet = (ResultSet) statement.executeQuery();
			while (resultSet.next()) {
				firstName = resultSet.getString("first_name");
				middleName = resultSet.getString("middle_name");
				lastName = resultSet.getString("last_name");
				accountType = resultSet.getString("account_type");
				gender = resultSet.getString("gender");
				dateOfBirth = resultSet.getString("date_of_birth");
				profileUrl = resultSet.getString("profile_url");
				isActive = resultSet.getString("active").equals("1") ? true : false;

				UserBean user = new UserBean();
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setAccountType(accountType);
				user.setGender(gender);
				user.setDateOfBirth(dateOfBirth);
				user.setProfileUrl(profileUrl);
				user.setIsActive(isActive);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
