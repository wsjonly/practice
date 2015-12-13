package com.wsjonly.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
   
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "wsj1109";

        try {
//        	Class.forName("com.mysql.jdbc.Driver");
        	DriverManager.registerDriver(new Driver());
            con = (Connection) DriverManager.getConnection(url, user, password);
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from User");

            while (rs.next()) {
                System.out.println(rs.getString(2) + "\t" + rs.getString(3));
            }
            
            ResultSet rs2 = st.executeQuery("select * from User as U where U.id=1");
            while (rs2.next()) {
                System.out.println(rs2.getString(2) + "\t" + rs2.getString(3));
            }

        } catch (Exception ex) {
//        	System.out.println("connection error");
        	ex.printStackTrace();

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
