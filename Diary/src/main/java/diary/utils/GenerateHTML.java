package diary.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateHTML {

	private static final Logger LOGGER = Logger.getLogger(GenerateHTML.class);

	private static Configuration cfg = null;
	

	/**
	 * 返回一个静态化后的地址
	 * @paramds root 项目的根路径
	 * * 
     * @param servletContext javax.servlet.ServletContext 初始化模板配置 
	 */
	public String generation(String dir, Map<String, Object> map,ServletContext servletContext) {
		
		Template template = null;

		// 首先将配置文件初始化
		if (cfg == null) {
			cfg = new Configuration();
		}

		// 设置默认的字符编码
		cfg.setDefaultEncoding(ConstantUtils.DefaultEncoding);
		
		
		//设置模板所在的位置
		
		//1.
		//cfg.setServletContextForTemplateLoading(strings, "html");
		
		//2   ServletContext servletContext "" 你项目中的位置
		cfg.setServletContextForTemplateLoading(servletContext, "");
		
		
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		//文件名和文件地址 filename
		String filename = "";
		
		
		String filepath = dir+filename;
		
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(new File(filepath)));
		} catch (FileNotFoundException e1) {
			LOGGER.error("对不起，文件输出出现了错误");
			e1.printStackTrace();
		}
		
		//得到模板的名字
		try {
			template = cfg.getTemplate("");
		} catch (IOException e) {
			LOGGER.error("对不起，没有找到模板文件");
			e.printStackTrace();
		}
		
		try {
			template.process(map, out);
		} catch (TemplateException e) {
			LOGGER.error("对不起，生成文件时出错了");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return filepath;
	}

}
