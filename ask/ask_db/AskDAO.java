package com.ask.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AskDAO {
	//DB작업 및 처리 객체
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql=""; 
	
	//디비 연결 메서드
	private Connection getCon() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/model2");
		con = ds.getConnection();
		return con;
	}

	//디비 자원해제 메서드
	public void closeDB(){
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
