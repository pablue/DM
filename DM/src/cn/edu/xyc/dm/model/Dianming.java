package cn.edu.xyc.dm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Dianming
 * @Description: 用于存放点名信息
 * @author: Enzo
 * @time: 2014年12月5日
 * 
 */
public class Dianming implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 点名表的ID
	 */
	private long did;

	/**
	 * 点名表对应的班级
	 */
	private Banji banji;

	/**
	 * 点名表对应的教师
	 */
	private Teacher tercher;

	/**
	 * 课程
	 */
	private Course course;

	/**
	 * 点名时的星期
	 */
	private String weektime;

	/**
	 * 点名时的节课
	 */
	private JieCi jieci;

	/**
	 * 创建点名表的时间
	 */
	private Date ctime;

	/**
	 * 将到的人放到一个集合中
	 */
	private String[] passstudent;

	/**
	 * 点名的总人数
	 */
	private int dianmingnum;

	/**
	 * 是否是调课的 >>状态 :正常，调课
	 */
	private String ischange;

	/**
	 * 将缺席的人放到一个集合中
	 */
	private String[] absence;

	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

	public Banji getBanji() {
		return banji;
	}

	public void setBanji(Banji banji) {
		this.banji = banji;
	}

	public Teacher getTercher() {
		return tercher;
	}

	public void setTercher(Teacher tercher) {
		this.tercher = tercher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getWeektime() {
		return weektime;
	}

	public void setWeektime(String weektime) {
		this.weektime = weektime;
	}

	public JieCi getJieci() {
		return jieci;
	}

	public void setJieci(JieCi jieci) {
		this.jieci = jieci;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String[] getPassstudent() {
		return passstudent;
	}

	public void setPassstudent(String[] passstudent) {
		this.passstudent = passstudent;
	}

	public int getDianmingnum() {
		return dianmingnum;
	}

	public void setDianmingnum(int dianmingnum) {
		this.dianmingnum = dianmingnum;
	}

	public String[] getAbsence() {
		return absence;
	}

	public void setAbsence(String[] absence) {
		this.absence = absence;
	}

	public String getIschange() {
		return ischange;
	}

	public void setIschange(String ischange) {
		this.ischange = ischange;
	}

}
