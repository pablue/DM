package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Set;

public class JieCi implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 上课节次id
	 */
	private long jid;
	
	/**
	 * 上课节次名字
	 */
	private String jname;
	
	/**
	 * 星期几的
	 */
	private WeekTime weektime;
	
	/**
	 * 一个节次内的课程
	 */
	private Set<Course> course;

	public long getJid() {
		return jid;
	}

	public void setJid(long jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public WeekTime getWeektime() {
		return weektime;
	}

	public void setWeektime(WeekTime weektime) {
		this.weektime = weektime;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	
	
	

}
