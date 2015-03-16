package cn.edu.xyc.dm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xyc.dm.dao.CourseDao;
import cn.edu.xyc.dm.model.Course;
import cn.edu.xyc.dm.service.CourseService;

@Service(CourseService.COURSESERVICE_NAME)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	/**
	 * 根据教师传递过来的ID，进行查询出该教师所教的课程
	 * @author enzo
	 * @param id 教师id  数据类型为<code>int</code> 
	 * @return List<Course> 里面存放了course表里的  cid,cname
	 */
	@Override
	public List<Course> getcoursebytid(int id) {
		return this.courseDao.getcoursebytid(id);
	}

	@Override
	public List getbanji(int tid, int cid) {
		
		return this.courseDao.getbanji(tid,cid);
	}
}
