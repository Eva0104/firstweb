package com.zhuxiaoxue.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanRowMapper<T> implements BuildEntity<T> {
	private Class<T> type;

	public BeanRowMapper(Class<T> t) {
		this.type = t;
	}

	@Override
	public T build(ResultSet rs) throws SQLException {
		T obj = null;
		try {
			obj = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSetMetaData rsmd = rs.getMetaData();
		Method[] med = type.getMethods();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			String clabel = rsmd.getColumnLabel(i);
			String meth = "set" + clabel.substring(0, 1).toUpperCase() + clabel.substring(1);
			for (Method method : med) {
				if (method.getName().equals(meth)) {
					try {
						method.invoke(obj, rs.getObject(i));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return obj;
	}
}
