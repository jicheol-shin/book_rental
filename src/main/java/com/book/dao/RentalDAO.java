package com.book.dao;

import java.sql.Connection;
import javax.sql.DataSource;

public class RentalDAO {

	private RentalDAO() {}
	private static RentalDAO rentalDAO;
	public static RentalDAO getInstance() {
		if(rentalDAO == null) rentalDAO = new RentalDAO();
		return rentalDAO;
	}

	Connection conn = null;
	DataSource ds = null;

	// DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	
	
	
	
	
	
}
