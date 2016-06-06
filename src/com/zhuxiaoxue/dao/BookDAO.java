package com.zhuxiaoxue.dao;

import java.util.List;

import com.zhuxiaoxue.entity.Book;
import com.zhuxiaoxue.tools.BeanRowMapper;
import com.zhuxiaoxue.tools.DBHelper;

public class BookDAO {
	DBHelper<Book> db = new DBHelper<>(Confg.URL);
	BeanRowMapper<Book> be = new BeanRowMapper<>(Book.class);

	public int add(Book b) {
		String sql = "insert into book (code,title,author,publishing,total,count) values (?,?,?,?,?,?)";
		return db.doUpdate(sql, b.getCode(),b.getTitle(),b.getAuthor(),b.getPublishing(),b.getTotal(),b.getCount());
	}
	public int update(Book b){
		String sql = "update book set title=?,author=?,publishing=?,total=?,count=? where code=?";
		return db.doUpdate(sql, b.getTitle(),b.getAuthor(),b.getPublishing(),b.getTotal(),b.getCount(),b.getCode());
	}
	public int updateById(Book b){
		String sql = "update book set code=?,title=?,author=?,publishing=?,total=?,count=? where id=?";
		return db.doUpdate(sql, b.getCode(),b.getTitle(),b.getAuthor(),b.getPublishing(),b.getTotal(),b.getCount(),b.getId());
	}
	public int delete(Book b){
		String sql = "delete from book where code=?";
		return db.doUpdate(sql, b.getCode());
	}
	public int delete(int id){
		String sql = "delete from book where id=?";
		return db.doUpdate(sql, id);
	}
	public Book find(String code){
		String sql = "select * from book where code=?";
		Book b = db.queryOne(sql, be, code);
		return b ;
	}
	public List<Book> findBook(String str){
		String sql = "select * from book where title like '%"+ str + "%' or author like '%"+ str + "%' or code like '%" + str + "%'";
		return db.queryList(sql, be);
	}
	public List<Book> findBooks(){
		String sql = "select * from book";
		return db.queryList(sql, be);
	}
	public int saveCount(Book book){
		String sql = "update book set count=? where code=?";
		return db.doUpdate(sql, book.getCount(),book.getCode());
	}
	public List<Book> findBookByCard(String ccode){
		String sql = "select book.* from book inner join borrow on borrow.bid = book.id inner join card on card.id = borrow.cid where card.code=?";
		return db.queryList(sql, be, ccode);
	}
	public Book findBookById(int id){
		String sql = "select * from book where id=?";
		return db.queryOne(sql, be, id);
	}
	
	

}
