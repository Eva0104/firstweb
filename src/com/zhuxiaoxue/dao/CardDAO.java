package com.zhuxiaoxue.dao;

import java.util.List;

import com.zhuxiaoxue.entity.Card;
import com.zhuxiaoxue.tools.BeanRowMapper;
import com.zhuxiaoxue.tools.DBHelper;

public class CardDAO {
	DBHelper<Card> db = new DBHelper<>(Confg.URL);
	BeanRowMapper<Card> be = new BeanRowMapper<>(Card.class);

	public int addCard(Card card) {
		String sql = "insert into card (code,name,tel) values(?,?,?)";
		return db.doUpdate(sql, card.getCode(), card.getName(), card.getTel());
	}

	public boolean upCard(Card card) {
		String sql = "update card set code=?,name=?,tel=? where id=?";
		int i = db.doUpdate(sql, card.getCode(), card.getName(), card.getTel(),
				card.getId());
		return i == 1;
	}

	public int delCard(int id) {
		String sql = "delete from card where id=?";
		return db.doUpdate(sql, id);
	}

	public Card findCard(String code) {
		String sql = "select * from card where code=?";
		return db.queryOne(sql, be, code);
	}

	public Card findCard(int id) {
		String sql = "select * from card where id=?";
		return db.queryOne(sql, be, id);
	}

	public List<Card> findCard() {
		String sql = "select * from card ";
		return db.queryList(sql, be);
	}

	public List<Card> findCards(String str) {
		String sql = "select * from card where code like '%" + str + "%' or name like '%" + str + "%'";
		return db.queryList(sql, be);
	}

}
