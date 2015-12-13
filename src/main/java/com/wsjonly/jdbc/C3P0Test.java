package com.wsjonly.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class C3P0Test {
	public static void main(String[] args) throws PropertyVetoException, SQLException {
		C3P0ConnectionManager connectionManager = C3P0ConnectionManager.getConnectionInstance();
		Connection connection = connectionManager.getDataSource();
		PreparedStatement statement = connection.prepareStatement("select * from User");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
            System.out.println(rs.getString(2) + "\t" + rs.getString(3));
        }
	}
}
