package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @ClassName: Course
 * @Description: 用于存放班级信息
 * @author: Enzo
 * @time: 2014年12月5日
 * 
 */

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 课程ID
	 */

	private long cid;

	/**
	 * 课程名字
	 */
	private String cname;

	/**
	 * 一门课程有多个教师
	 */
	private Set<Teacher> teachers;

	/**
	 * 一门课程有多个班级
	 */
	private Set<Course> banjis;

	private Set weektime;

	public Set getWeektime() {
		return weektime;
	}

	public void setWeektime(Set weektime) {
		this.weektime = weektime;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Course> getBanjis() {
		return banjis;
	}

	public void setBanjis(Set<Course> banjis) {
		this.banjis = banjis;
	}

}
