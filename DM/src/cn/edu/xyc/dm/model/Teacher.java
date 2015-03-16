package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @ClassName: Teacher
 * @Description: 存放教师的信息 
 * @author: Enzo
 * @time: 2014年12月5日
 *
 */
public class Teacher  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 教师ID
	 */
	private long tid;

	/**
	 * 教师名字
	 */
	private String tname;
	
	
	/**
	 * 教师登陆的密码
	 */
	private String password;

	/**
	 * 职工id
	 */
	private String tno;
	
	
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	/**
	 * 一个教师有多门课程
	 */
	private Set<Course> courses;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	/**
	 * add a course to teacher
	 * @param courses  a course 
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
