package diary.action;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;

import diary.action.base.BaseAction;
import diary.pagemodel.Diary;
import diary.pagemodel.User;
import diary.utils.ConstantUtils;


@Action(value="/diary", results={@Result(name="error",location="/error.jsp",type="redirect") })
public class DiaryAction extends BaseAction implements ModelDriven<Diary>{
	
	
	private static final long serialVersionUID = 5306959760888412325L;
	
	
	private static final Logger LOGGER   = Logger.getLogger(DiaryAction.class);
	
	private Diary diary = new Diary();

	public Diary getModel() {
		return diary;
	}
	
	
	//添加一个日记事件
	public String add(){
		//从Session中得到用户的信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute(ConstantUtils.LOGIN_SESSION);
		
		if(user==null){
			LOGGER.error("没有获取到用户的信息，或者是Session失效");
			return ERROR;
		}
		
		Diary model = this.getModel();
		
		model.setUid(user.getUserId());
		
		LOGGER.info("content:"+model.getContent());
		LOGGER.info("title:"+model.getTitle());
		LOGGER.info("uid:"+model.getUid());
		this.diaryService.addDiary(model);
		
		return null;
		
	}
	
	
	

}
