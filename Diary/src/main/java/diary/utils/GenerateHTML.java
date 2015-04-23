package diary.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateHTML {

	private static Configuration cfg = null;

	/**
	 * 返回一个静态化后的地址  默认的加载模板文件目录是在项目的 <code> /WEB-INF/ftl</code> 中
	 * 
	 * @paramds Map 生成静态文件所要的Map集合数据
	 * @param TYPE
	 *            生成什么类型的静态模板文件 ,也就是 <code> /WEB-INF/ftl</code>下模板文件的模板文件名
	 * @param servletContext
	 *            javax.servlet.ServletContext 初始化模板配置
	 * @return String 返回文件在项目中的相对位置的路径地址
	 */
	public static String generation(Map<String, Object> map, String TYPE) {

		Template template = null;
		ServletContext servletContext = ServletActionContext.getServletContext();

		// 首先将配置文件初始化
		if (cfg == null) {
			cfg = new Configuration();
		}

		// 设置默认的字符编码
		cfg.setDefaultEncoding(ConstantUtils.DefaultEncoding);

		// 设置模板所在的位置

		// 1.
		// cfg.setServletContextForTemplateLoading(strings, "html");

		// 2 ServletContext servletContext "" 你项目中的位置
		cfg.setServletContextForTemplateLoading(servletContext, "/WEB-INF/ftl");

		cfg.setObjectWrapper(new DefaultObjectWrapper());

		// 文件名和文件地址 filename
		String projectpath = servletContext.getRealPath("html");

		String filepath = Generationfilename() + ".html";
		String fullpath = projectpath + "\\" + filepath;

		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(new File(fullpath)), ConstantUtils.DefaultEncoding);

			// 得到生成模板的类型的名字
			template = cfg.getTemplate(TYPE);

			template.process(map, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//对文件内容进行压缩
		try {
			Htmlcompressor.cssCompress(fullpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//切割文件名，截取项目的相对路径
		String replaceAll = fullpath.replaceAll("\\\\", "/");
		int indexOf = replaceAll.indexOf(servletContext.getContextPath());
		CharSequence subSequence = replaceAll.subSequence(indexOf, replaceAll.length());
		return (String) subSequence;
	}

	/**
	 * 根据时间来用来生成页面的路径名
	 * 
	 * @return
	 */
	public static String Generationfilename() {
		StringBuffer stringBuffer = new StringBuffer();
		String name = "diary";
		String Shortline = "-";
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		String curTime = simpleDateFormat.format(date);
		stringBuffer.append(name);
		stringBuffer.append(Shortline);
		stringBuffer.append(curTime);
		Random random = new Random();
		int num = random.nextInt(1000);
		stringBuffer.append(Shortline);
		stringBuffer.append(num);
		return new String(stringBuffer);

	}

	public static void main(String[] args) {

	}

}
