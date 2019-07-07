package com.workorders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOrdersApplication.class, args);
		
		//Connection to Sqlite database
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:./workorder.db", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		
	}

	}


