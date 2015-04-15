package diary.action.base;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import diary.service.DiaryServiceI;
import diary.service.RepairServiceI;
import diary.service.TypeServiceI;
import diary.service.UserServiceI;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// 注入Service
	/********************************/
	@Resource(name = UserServiceI.USER_SERVICE_NAME)
	protected UserServiceI userService;

	@Resource(name = RepairServiceI.REPAIR_SERVICE_NAME)
	protected RepairServiceI repairServiceI;

	@Resource(name = DiaryServiceI.DIARY_SERVICE_NAME)
	protected DiaryServiceI diaryService;
	
	@Resource(name =TypeServiceI.TYPE_SERVICE_NAME)
	protected TypeServiceI typeServiceI;

	
	/**
	 * 向前台写入<code>json</code>数据
	 */
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
