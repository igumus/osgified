package com.wf.dao.base;

import java.util.List;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.model.IEntity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractJPADao<T extends IEntity> implements IDao<T> {

	private SessionFactory sessionFactory = null;

	public AbstractJPADao() {
	}

	protected final Session openSession() {
		if (this.sessionFactory != null)
			return this.sessionFactory.openSession();
		return null;
	}

	@Override
	public void save(T entity) throws SessionFactoryNotAvaliableException, Exception {
		Session session = openSession();
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			try {
				session.saveOrUpdate(entity);
				session.flush();
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				throw e;
			} finally {
				session.clear();
				session.close();
			}
		} else {
			throw new SessionFactoryNotAvaliableException();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> query(String sql, Mapper map) throws SessionFactoryNotAvaliableException {
		Session session = openSession();
		if (session != null) {
			try {
				return map.query(session, sql);
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.clear();
				session.close();
			}
		}

		throw new SessionFactoryNotAvaliableException();
	}

	public void setSessionFactory(SessionFactory aSessionFactory) {
		this.sessionFactory = aSessionFactory;
		System.out.println(SessionFactory.class.getSimpleName() + " has just registered to " + this.getClass().getSimpleName());
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
