package cn.edu.xyc.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

import cn.edu.xyc.dm.model.Teacher;
import cn.edu.xyc.dm.service.CourseService;
import cn.edu.xyc.dm.service.TeacherService;
import cn.edu.xyc.util.MD5;

@Scope("prototype")
@Controller("loginAction")
public class LoginAction extends ActionSupport {
	@Resource(name = "teacherService")
	protected TeacherService teacherService;

	private String username;
	private String password;
	private String rand;

	
	/**
	 * @author: enzo
	 * @Description: 教师登录 可以用教师的用户名和教师的学工号进行登录
	 * @return error or success  表示用户登录失败和成功
	 */
	public String login() {
		try {
			// 根据session中的rand 中的值来进行判断
			if (!rand.equalsIgnoreCase((String) ServletActionContext
					.getRequest().getSession().getAttribute("rand"))) {
				this.addActionError(getText("login_rand_error"));
				System.out.println("gettextxinxi" +getText("login_rand_error"));
				this.addActionMessage("123123");
				System.out.println("验证码错误");
				return ERROR;
			}else{
				Teacher teacher = teacherService.login(username, MD5.MD5Encode(password));
				if(teacher!=null){
					ServletActionContext.getRequest().getSession().setAttribute("teacher", teacher);
					return SUCCESS;
				}else{
					this.addActionError(getText("用户名或密码错误！"));
					return ERROR;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author enzo
	 * @Description:  对已经登录的用户进行注销操作
	 * @return: void
	 */
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("teacher");
		session.invalidate();
		return "logout";
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}
}
