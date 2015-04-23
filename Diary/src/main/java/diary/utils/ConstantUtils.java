package diary.utils;

/**
 * 用于存放不变量的常量
 * 
 * @author Administrator
 * 
 */
public class ConstantUtils {

	/**
	 * LOGIN_SESSION 登陆时存放到Session中值的名称
	 */
	public static final String LOGIN_SESSION = "user";

	/**
	 * 设置成默认的字符编码
	 */
	public static final String DefaultEncoding = "UTF-8";

	/**
	 * 默认pagesize的大小
	 */

	public static final int DefaultPageSize = 10;

	/**
	 * 加载的是显示页面的模板文件
	 */
	public static final String ShowDiaryList = "listdiary.ftl";

	/**
	 * 导航条的模板文件
	 */
	public static final String NAVFTL = "nav.ftl";

	/**
	 * 页脚的模板文件
	 */
	public static final String FOOTERFTL = "footer.ftl";

	/**
	 * 日记内容的模板文件
	 */
	public static final String DIARYFTL = "diary.ftl";
}
