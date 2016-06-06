package com.zhuxiaoxue.dao;

import java.util.List;

import com.zhuxiaoxue.entity.Borrow;
import com.zhuxiaoxue.tools.BeanRowMapper;
import com.zhuxiaoxue.tools.DBHelper;

public class BorrowDAO {
	DBHelper<Borrow> db = new DBHelper<>(Confg.URL);
	BeanRowMapper<Borrow> be = new BeanRowMapper<>(Borrow.class);

	public int addBorrow(Borrow borrow){
		String sql = "insert into borrow (bid,cid) values(?,?)";
		return db.doUpdate(sql, borrow.getBid(),borrow.getCid());
	}
	public int removeBorrow(Borrow borrow){
		String sql = "delete from borrow where cid=? and bid=?";
		return db.doUpdate(sql, borrow.getCid(),borrow.getBid());
	}
	public List<Borrow> findBorrow(){
		String sql="select * from borrow";
		return db.queryList(sql, be);
	}
	
	
}
