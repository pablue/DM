package cn.edu.xyc;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.xyc.dm.model.Teacher;

public class SessionFactoryTest {

	@Test
	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory bean = (SessionFactory)context
				.getBean("sessionFactory");
		System.out.println(bean);
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Transaction beginTransaction = session.beginTransaction();
		 Teacher teacher = new Teacher();
		 teacher.setTid(6L);
		 teacher.setTname("张三");
		 teacher.setPassword("123");
		 session.save(teacher);
		
		 beginTransaction.commit();
		
	}
	
	@Test
	public void reflush(){
		Configuration  config=new Configuration().configure();
		
		SchemaExport   export=new SchemaExport(config);
		export.create(true, true);
	}
 
}
