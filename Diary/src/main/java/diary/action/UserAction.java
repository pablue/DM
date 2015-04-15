package diary.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import diary.action.base.BaseAction;
import diary.pagemodel.Json;
import diary.pagemodel.Type;
import diary.pagemodel.User;
import diary.utils.ConstantUtils;
/**
 * <code>type:</code>
 * <code>redirect</code>
 * <code>redirectAction</code>
 * <code>dispatcher</code>
 * @author Administrator
 *
 */
@Action(value = "userAction", results = {
			@Result(name = "success", location = "/userAction!mainUI.action", type = "redirect"),
			@Result(name = "input", location = "/login.jsp" ,type = "dispatcher"), 
			@Result(name = "main", location = "/main.jsp" ,type = "dispatcher"), 
			@Result(name = "addtype", location = "/jsps/adddiary.jsp", type = "dispatcher"),
			@Result(name = "test", location = "/index.jsp", type = "redirect")

})
public class UserAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = -3868541754207941420L;
	

	private User user = new User();

	public User getModel() {
		return user;
	}

	private static final Logger logger = Logger.getLogger(UserAction.class);

	public void save() {

	}

	// 当注册时所用的方法
	public void reg() {
		Json j = new Json();
		try {
			this.userService.save(user);

			j.setSuccess(true);
			j.setMsg("注册成功");
			logger.info(user.getUserName() + j.getMsg());
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			e.printStackTrace();
		}
		super.writeJson(j);
	}

	
	
	// 当登陆时进行的方法
	public String login() {
		Json j = new Json();
		try {
			User user2 = this.userService.login(user);
			if (user2 != null) {

				// 获取一个Session
				HttpSession session = getHttpRequest().getSession();
				session.setAttribute(ConstantUtils.LOGIN_SESSION, user2);

				j.setSuccess(true);
				j.setMsg(getText("login_success"));

				// 将json里面的数据通过request传递到页面中
				getHttpRequest().setAttribute("json", j);

				return SUCCESS;
			}

		} catch (Exception e) {
			j.setMsg(e.getMessage());
			e.printStackTrace();
			this.addActionError(getText("login_error"));
			return INPUT;
		}
		this.addActionError(getText("login_error"));
		return INPUT;

	}

	public String mainUI() {
		

		return "main";
	}
	
	
	public String addtypeui(){
		HttpSession session = getHttpRequest().getSession();
		User uesr2 = (User) session.getAttribute(ConstantUtils.LOGIN_SESSION);
		List<Type> list = this.typeServiceI.list(uesr2.getUserId());
		ActionContext.getContext().put("types", list);
		return "addtype";
	}

	// 得到HTTP中的request
	public HttpServletRequest getHttpRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
	
}
