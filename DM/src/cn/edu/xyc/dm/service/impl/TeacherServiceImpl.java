package cn.edu.xyc.dm.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xyc.dm.dao.TeacherDao;
import cn.edu.xyc.dm.model.Teacher;
import cn.edu.xyc.dm.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherdao;

	public Teacher login(String username, String password) {
		// TODO Auto-generated method stub
		return this.teacherdao.login(username, password);
	}

}
