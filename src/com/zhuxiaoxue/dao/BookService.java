package com.zhuxiaoxue.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookService {
	public String borrowBook(String bookCode,String cardCode){
		return callPro("{call pro_borrow_book(?,?,?)}",bookCode,cardCode);
	}
	public String reBook(String bookCode,String cardCode){
		return callPro("{call pro_re_book(?,?,?)}",bookCode,cardCode);
	}
	private String callPro(String proName,String bookCode,String cardCode){
		String str="";
			try {
				Connection conn = DriverManager.getConnection(com.zhuxiaoxue.dao.Confg.URL);
				CallableStatement cstmt = conn.prepareCall(proName); 
				cstmt.setString(1, bookCode); 
				cstmt.setString(2, cardCode); 

				cstmt.executeQuery();
				str = cstmt.getString(3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return str;
	}
}
