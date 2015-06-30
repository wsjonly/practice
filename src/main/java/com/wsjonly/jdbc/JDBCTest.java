package com.wsjonly.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/javapapers";
        String user = "root";
        String password = "wsj1109";

        try {
            con = (Connection) DriverManager.getConnection(url, user, password);
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from message");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (SQLException ex) {
        	System.out.println("connection rror");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
            	System.out.println("close error");
            }
        }
	}
}
