package com.bean;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connectionbean {
 Connection conn=null;
 private DataSource database;
   public connectionbean() throws SQLException{	   
	   try {
		Context context = new InitialContext();
			database=(DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn=database.getConnection(); 
		} catch (NamingException e) {
			e.printStackTrace();
		}
				}

 	public  Connection getConnection(){
		return conn;		
 	}
 	public void close() throws SQLException {
 		if(conn!=null) {
 			conn.close();
 		}
 	}
}
