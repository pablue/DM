package diary.action;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import diary.action.base.BaseAction;
import diary.pagemodel.Diary;
import diary.pagemodel.Page;
import diary.pagemodel.User;
import diary.utils.ConstantUtils;

@Action(value = "diary", results = { 
		@Result(name = "error", location = "/error.jsp", type = "redirect"), 
		@Result(name = "listall", location = "/WEB-INF/jsp/listdiary.jsp"),
		@Result(name = "mainUI", location = "/userAction!mainUI.action", type = "redirect"),
		@Result(name = "showdiary",location = "/WEB-INF/jsp/showdiary.jsp")

})
public class DiaryAction extends BaseAction implements ModelDriven<Diary> {

	private static final long serialVersionUID = 5306959760888412325L;

	private static final Logger LOGGER = Logger.getLogger(DiaryAction.class);

	private Diary diary = new Diary();

	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Diary getModel() {
		return diary;
	}

	// 添加一个日记事件
	public String add() {
		// 从Session中得到用户的信息
		User user = islogin();

		if (user == null) {
			LOGGER.error("没有获取到用户的信息，或者是Session失效");
			return ERROR;
		}

		Diary model = this.getModel();

		model.setUid(user.getUserId());

		this.diaryService.addDiary(model);

		return "mainUI";

	}

	public String listall() {

		
		User user = islogin();
		if (user == null) {
			LOGGER.error("没有获取到用户的信息，或者是Session失效");
			return ERROR;
		} else if (page <= 0) {
			page = 1;
		}
		
		Page<Diary> pagemodel = this.diaryService.list(user.getUserId(),page, ConstantUtils.DefaultPageSize);
		
		ActionContext.getContext().put("diarylist", pagemodel);
		LOGGER.info("取出成功");

		return "listall";

	}

	/**
	 * 判断是否登陆
	 */
	public User islogin() {
		// 从Session中得到用户的信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute(ConstantUtils.LOGIN_SESSION);

		if (user == null) {

			return null;
		}
		return user;
	}
	
	public String show(){
		try {
			Diary showdiary = this.diaryService.showdiary(diary.getDiaryId());
			ActionContext.getContext().put("diary", showdiary);
		} catch (Exception e) {
			LOGGER.error("查看日记出错了！！！");
			e.printStackTrace();
		}
		
		return "showdiary";
	}

}
