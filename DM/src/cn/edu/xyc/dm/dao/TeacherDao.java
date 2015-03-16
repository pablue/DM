package cn.edu.xyc.dm.dao;

import cn.edu.xyc.dm.model.Teacher;

public interface TeacherDao {

	/**
	 * 登陆到系统中
	 * 
	 * @param username
	 *            用户名 是教师名字或者职工号，类型 为字符串
	 * @param password
	 *            密码，对其进行加密
	 */
	public Teacher login(String username, String password);

}
