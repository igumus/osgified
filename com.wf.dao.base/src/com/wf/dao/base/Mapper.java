package com.wf.dao.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.wf.model.IEntity;

public abstract class Mapper<T extends IEntity> {

	public Mapper() {
	}

	public abstract T map(ResultSet resultSet) throws SQLException;

	public List<T> query(Session session, final String sql) {

		final List<T> result = new ArrayList<T>();
		session.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					statement = connection.createStatement();
					resultSet = statement.executeQuery(sql);
					T obj = null;
					while (resultSet.next()) {
						obj = map(resultSet);
						result.add(obj);
					}
				} catch (HibernateException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						resultSet.close();
						statement.close();
						resultSet = null;
						statement = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});

		return result;
	}
}
