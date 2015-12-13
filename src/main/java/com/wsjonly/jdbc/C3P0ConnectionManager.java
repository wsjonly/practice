package com.wsjonly.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0ConnectionManager {
	private static C3P0ConnectionManager connectionInstance;
	private static ComboPooledDataSource dataSource;

	private C3P0ConnectionManager() throws PropertyVetoException {
		dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("wsj1109");
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setInitialPoolSize(5);
		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(10);
		dataSource.setMaxStatements(50);
		dataSource.setMaxIdleTime(60);
	}

	public static C3P0ConnectionManager getConnectionInstance() throws PropertyVetoException {
		if(connectionInstance == null) {
			connectionInstance = new C3P0ConnectionManager();
		} else 
			return connectionInstance;
		return connectionInstance;
	}
	
	public final synchronized Connection getDataSource() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
