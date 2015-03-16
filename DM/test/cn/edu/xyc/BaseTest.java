package cn.edu.xyc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.xyc.dao.impl.TeacherDaoImpl;
import cn.edu.xyc.dm.model.Teacher;

public class BaseTest {
	
	public static ApplicationContext context;
	
	@Before
	public void startmethod(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
	@Test
	public void boleanlogintest(){
		TeacherDaoImpl impl =new TeacherDaoImpl();
		Teacher login = impl.login("李四", "123");
		if (login!=null) {
			System.out.println("登录成功！！！");
		}
	}
}
	
	
	