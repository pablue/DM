package cn.edu.xyc.dm.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: Student
 * @Description: 存储学生的信息
 * @author: Enzo
 * @time: 2014年12月5日
 * 
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 学生id
	 */
	private long sid;

	/**
	 * 学生学号
	 */
	private String sno;

	/**
	 * 学生名字
	 */
	private String sname;

	/**
	 * 学生对应的班级
	 */
	private Banji banji;

	/**
	 * 学生电话
	 */
	private String tel;

	/**
	 * 学生性别
	 */
	private String sex;

	/**
	 * 学生寝室
	 */
	private String dorm;

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Banji getBanji() {
		return banji;
	}

	public void setBanji(Banji banji) {
		this.banji = banji;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

}
