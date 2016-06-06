package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.Admin;
import com.zhuxiaoxue.tools.BeanRowMapper;
import com.zhuxiaoxue.tools.DBHelper;

public class AdminDAO {
	DBHelper<Admin> db = new DBHelper<>(Confg.URL);
	BeanRowMapper<Admin> be = new BeanRowMapper<>(Admin.class);
	
	public boolean find(String name,String psw){
		String sql = "select * from admin where name=? and password=?";
		Admin a = db.queryOne(sql, be, name,psw);
		return a != null;
	}
}
