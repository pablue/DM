package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 调课用的类
 * @ClassName: ChangeClass
 * @Description: 
 * @author: Enzo
 * @time: 2015年1月13日
 *
 */
public class ChangeClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private long ccid;

	/**
	 * teacher 表
	 */
	private Teacher teacher;

	/**
	 * 
	 */
	private Date changtime;
	/**
	 * 调课的班级
	 */
	private Banji banji;

	/**
	 * 调课到星期几
	 */
	private WeekTime weekTime;
	/**
	 * 调课到第几节课
	 */
	private JieCi jieCi;

	public long getCcid() {
		return ccid;
	}

	public void setCcid(long ccid) {
		this.ccid = ccid;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getChangtime() {
		return changtime;
	}

	public void setChangtime(Date changtime) {
		this.changtime = changtime;
	}

	public Banji getBanji() {
		return banji;
	}

	public void setBanji(Banji banji) {
		this.banji = banji;
	}

	public WeekTime getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(WeekTime weekTime) {
		this.weekTime = weekTime;
	}

	public JieCi getJieCi() {
		return jieCi;
	}

	public void setJieCi(JieCi jieCi) {
		this.jieCi = jieCi;
	}

}
