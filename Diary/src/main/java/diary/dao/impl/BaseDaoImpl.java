package diary.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import diary.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

	public Serializable save(T o) {
		if (o != null) {
			return getCurrentSession().save(o);
		}
		return null;
	}

	public void delete(T o) {
		if (o != null) {
			getCurrentSession().delete(o);
		}

	}

	public void update(T o) {
		if (o != null) {
			getCurrentSession().update(o);
		}

	}

	public void saveOrUpdate(T o) {
		if (o != null) {
			getCurrentSession().saveOrUpdate(o);
		}

	}

	@SuppressWarnings("unchecked")
	public T getById(Class<T> c, Serializable id) {
		return (T) getCurrentSession().get(c, id);
	}

	public T getByHql(String hql) {

		return getByHql(hql, null);
	}

	public T getByHql(String hql, Map<String, Object> params) {
		List<T> find = find(hql, params);
		if (find != null && find.size() > 0) {
			logger.info("执行getByHql()");
			return find.get(0);
		}
		return null;
	}

	public List<T> find(String hql) {
		return find(hql, null);
	}

	public List<T> find(String hql, Map<String, Object> params) {
		logger.info("查找不分页");
		return find(hql, params, 1, count(hql, params));
	}

	public List<T> find(String hql, int page, int rows) {
		return find(hql, null, page, rows);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public int count(String hql) {
		return count(hql, null);
	}

	public int count(String hql, Map<String, Object> params) {
		String counthql = "select count(*) " + hql;
		return zhixingHQL(counthql, params);
	}

	public int executeHql(String hql) {
		return 0;
	}

	public int executeHql(String hql, Map<String, Object> params) {

		return 0;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> findBySql(String sql) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> findBySql(String sql, int page, int rows) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> findBySql(String sql, Map<String, Object> params) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		return null;
	}

	public int executeSql(String sql) {
		return 0;
	}

	public int executeSql(String sql, Map<String, Object> params) {
		return 0;
	}

	public BigInteger countBySql(String sql) {
		return null;
	}

	public BigInteger countBySql(String sql, Map<String, Object> params) {
		return null;
	}

	/**
	 * 用来查询总的条数
	 */
	public int zhixingHQL(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return ((Number) q.uniqueResult()).intValue();
	}

}
