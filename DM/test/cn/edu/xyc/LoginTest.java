package cn.edu.xyc;

import org.junit.Test;

import cn.edu.xyc.dao.impl.TeacherDaoImpl;
import cn.edu.xyc.dm.dao.TeacherDao;
import cn.edu.xyc.dm.model.Teacher;

public class LoginTest {
	
	@Test
	public void boleanlogintest(){
		TeacherDaoImpl impl =new TeacherDaoImpl();
		Teacher login = impl.login("李四", "123");
		if (login!=null) {
			System.out.println("登录成功！！！");
		}
	}

}
