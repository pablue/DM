package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @ClassName: WeekTime
 * @Description: 用于存放星期的表
 * @author: Enzo
 * @time: 2014年12月5日
 * 
 */
public class WeekTime implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long wid;

	private String weektime;

	private Set<Course> course;

	private Set<JieCi> jicis;

	public Set<JieCi> getJicis() {
		return jicis;
	}

	public void setJicis(Set<JieCi> jicis) {
		this.jicis = jicis;
	}

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public String getWeektime() {
		return weektime;
	}

	public void setWeektime(String weektime) {
		this.weektime = weektime;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

}
