package com.zhuxiaoxue.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper2<T> {
	private String url;
	private Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;
	
	public DBHelper2(String url){
		this.url = url;
	}

	public void getConn(String url) {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getStatement(String sql, Object... par) {
		getConn(url);
		try {
			stat = conn.prepareStatement(sql);
			for (int i = 0; i < par.length; i++) {
				stat.setObject(i + 1, par[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int doUpdate(String sql, Object... par) {
		getStatement(sql, par);
		try {
			return stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}

	}

	public T doQuery(String sql, BuildEntity<T> be, Object... par) {
		getStatement(sql, par);
		try {
			rs = stat.executeQuery();
			if ( rs.next()) {
				return be.build(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
	}

	public List<T> queryList(String sql, BuildEntity<T> be, Object... par) {
		getStatement(sql, par);
		try {
			List<T> list = new ArrayList<>();
			rs = stat.executeQuery();
			while (rs.next()) {
				list.add(be.build(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}

	}
	public void close(){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stat != null){
					stat.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn != null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
