package com.zhuxiaoxue.tools;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BuildEntity<T> {
	T build(ResultSet rs)throws SQLException;
}
