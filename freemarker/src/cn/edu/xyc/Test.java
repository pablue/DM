package cn.edu.xyc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Test {

	/**
	 * 使用的freemarker 的四个基本步骤
	 *             1.进行配置，
	 *             2.得到模板文件目录，
	 *             3.得到模板文件
	 *             4.向模板文件插入数
	 * @author 熊强强
	 * @date 2015/4/13
	 * 		
	 * @version 1.0
	 */

	public static void main(String[] args) throws Exception {
		// 1.freemark 进行初始化操作
		Configuration config = new Configuration();

		// 对其进行设置初始化的编码规范
		config.setDefaultEncoding("UTF-8");
		Template template = null;

		// 如果在你的在硬盘下没有test目录，将会出现错误
		File file = new File("c:\\test");

		// 3种方式加载模板文件的目录
		config.setDirectoryForTemplateLoading(file);
		// config.setClassForTemplateLoading(clazz, pathPrefix);
		// config.setServletContextForTemplateLoading(arg0, arg1);

		// 在模板文件目录里加载所需要使用的模板文件
		template = config.getTemplate("test2.ftl");
		
		//准备数据，将数据封装到一个Map集合当中
		Map<String, Object> m = new HashMap<String, Object>();

		person p = new person();

		p.setAge("123");
		p.setName("小王");
		p.setPassword("123456");

		person p1 = new person();

		p1.setAge("p1123");
		p1.setName("p1小王");
		p1.setPassword("p1123456");
		m.put("p", p);
		m.put("p1", p1);

		//向一个指定的文件写入数据流
		Writer out = new OutputStreamWriter(new FileOutputStream(new File(UUID.randomUUID().toString() + ".html")));

		//将文件输出出来
		template.process(m, out);
	}
}

class person {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String age;
}