package freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MyFreeMarkerTest {

	private static final Logger logger = Logger.getLogger(MyFreeMarkerTest.class);

	private static Configuration config = null;

	public static void main(String[] args) throws IOException, TemplateException {
		initconfig();
	}

	public static Configuration initconfig() throws IOException, TemplateException {
		if (config == null) {
			config = new Configuration();
		}
		config.setDefaultEncoding("UTF-8");  
		config.setDirectoryForTemplateLoading(new File("C:\\test"));
		
		//Properties p = new Properties();
		//p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("freemarker.properties"));

		Template template = config.getTemplate("test2.ftl", "UTF-8");
		logger.info(template);
		Map<String,String> root = new HashMap<String,String>();
		root.put("title", "this title ");
		
		Writer out = new OutputStreamWriter(new FileOutputStream("C:\\text1.html"));
		
		template.process(root, out);

		return config;

	}

}
