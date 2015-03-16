package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName: Banji
 * @Description: 用于存放班级信息的
 * @author: Enzo
 * @time: 2014年12月5日
 * 
 */

public class Banji implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 班级id
	 */
	private long bid;
	/**
	 * 班级名字
	 */
	private String bname;

	/**
	 * 一个班有多个课程
	 */
	private Set<Course> courses;

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	/**
	 * 在班级里面添加一门课程
	 * @param courses  课程表的信息
	 * @return: void
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
