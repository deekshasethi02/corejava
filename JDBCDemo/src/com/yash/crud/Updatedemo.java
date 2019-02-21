package com.yash.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Updatedemo {
	private static Logger logger = Logger.getLogger(InsertDemo.class);
	public static void main(String[] args) throws Exception {
	
		//1. Gather DB information
		// refer mysql mannual for Driver and url
		String driverClassName =  "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/mydb";
		String user = "root";
		String pwd = "root";
		
		//2. load driver or register driver
		
		Class c = Class.forName(driverClassName);
		c.newInstance(); //create object of loaded driver class,uses default constructor
		logger.info("class : " +c);
		
		//3. create connection object
		Connection con = DriverManager.getConnection(url,user,pwd);
		logger.info("object : "+con);
		
		
		//4. create statemet
		Statement stmt = con.createStatement();
		
		String sql = "update contact set name = 'alice' where id =3  ";
		stmt.executeUpdate(sql);
		logger.info("update successfully....!");
		//5. 
		stmt.close();
		con.close();
	}

}