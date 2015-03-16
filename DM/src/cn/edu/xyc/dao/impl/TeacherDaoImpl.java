package cn.edu.xyc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.xyc.dm.dao.TeacherDao;
import cn.edu.xyc.dm.model.Teacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	/**
	 * 登陆到系统中
	 * 
	 * @param username
	 *            用户名 是教师名字或者职工号，类型 为字符串
	 * @param password
	 *            密码，对其进行加密
	 */
	Teacher teacher;

	@Override
	public Teacher login(String username, String password) {
		Teacher teacher;
		@SuppressWarnings("unchecked")
		List<Teacher> list = this.getHibernateTemplate().find(
				"from Teacher AS t where t.tname=? AND t.password=?",
				new Object[] { username, password });

		if (!list.isEmpty()) {
			return teacher = list.get(0);
		}

		if (list == null || list.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Teacher> list2 = this.getHibernateTemplate().find(
					"from Teacher AS t where t.tno=? AND t.password=?",
					new Object[] { username, password });
			if (!list2.isEmpty()) {
				return teacher = list2.get(0);
			}
		}
		return null;
	}

}
