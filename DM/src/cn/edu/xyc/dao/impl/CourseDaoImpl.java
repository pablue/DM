package cn.edu.xyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.edu.xyc.dm.dao.CourseDao;
import cn.edu.xyc.dm.model.Banji;
import cn.edu.xyc.dm.model.Course;
import cn.edu.xyc.dm.model.Teacher;

@Repository(CourseDao.COURSEDAO_NAME)
public class CourseDaoImpl extends BaseDao implements CourseDao {

	/**
	 * 根据教师传递过来的ID，进行查询出该教师所教的课程
	 * 
	 * @author enzo
	 * @param id
	 *            教师id 数据类型为<code>int</code>
	 * @return List<Course> 里面存放了course表里的 cid,cname
	 */
	@Override
	public List<Course> getcoursebytid(int id) {
		final String queryString = "SELECT t.tid,t.tname,t.tno,c.cid,c.cname FROM dm_teacher  as t ,dm_course as c WHERE t.tid ="
				+ id;

		final List<Course> listcoursess = new ArrayList<Course>();
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@SuppressWarnings("deprecation")
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(queryString);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Course course = new Course();
					course.setCid(rs.getInt("cid"));
					course.setCname(rs.getString("cname"));
					listcoursess.add(course);
				}
				rs.close();
				ps.close();
				session.flush();
				session.close();
				return null;
			}
		});
		return listcoursess;
	}

	@Override
	public List getbanji(int tid, int cid) {
		final String sql = "SELECT b.bid, b.bname FROM dm_banji AS b , dm_teacher AS t , dm_course AS c where t.tid="
				+ tid + " AND c.cid=" + cid;

		final List<Banji> listBanjis = new ArrayList<Banji>();
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@SuppressWarnings("deprecation")
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection con = session.connection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Banji banji = new Banji();
					banji.setBid(rs.getInt("bid"));
					banji.setBname(rs.getString("bname"));
					
					listBanjis.add(banji);
				}
				return null;
			}
		});
		return listBanjis;
	}

}
