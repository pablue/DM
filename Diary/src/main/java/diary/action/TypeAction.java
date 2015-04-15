package diary.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;

import diary.action.base.BaseAction;
import diary.pagemodel.Type;
import diary.pagemodel.User;
import diary.utils.ConstantUtils;

@Action(value = "/type", results = { 
		@Result(name = "success", location = "/index.jsp") ,
		@Result(name="error" ,location="/error.jsp")

})
public class TypeAction extends BaseAction implements ModelDriven<Type> {

	private static final long serialVersionUID = 1L;

	Type type = new Type();

	public Type getModel() {
		return type;
	}

	public String add() {
		
		//获取应用 程序中的Session
		HttpSession session = ServletActionContext.getRequest().getSession();
		User obj = (User) session.getAttribute(ConstantUtils.LOGIN_SESSION);

		// 当没有Session时返回的值
		if (obj == null) {
			return ERROR;
		}
		type.setUid(obj.getUserId());
		this.typeServiceI.addType(type);

		return SUCCESS;
	}

}
