package cn.edu.xyc.dm.service;

import java.util.List;

import cn.edu.xyc.dm.model.Course;

public interface CourseService {

	public static String COURSESERVICE_NAME = "courseService";

	/**
	 * 根据教师 的id 去查询所要上的哪些课程
	 * 
	 * @param id
	 *            教师ID
	 * @return List<Course> 根据教师id所返回的一个课程数组
	 */
	public List<Course> getcoursebytid(int id);

	public List getbanji(int tid, int cid);

}
