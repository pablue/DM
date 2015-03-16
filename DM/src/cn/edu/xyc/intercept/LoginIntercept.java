package cn.edu.xyc.intercept;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginIntercept extends AbstractInterceptor {

	private static final long serialVersionUID = 5357069786868405574L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL
		invocation.getProxy().getActionName();
		if(object==null){
			if(privUrl.startsWith("/login_login")){
				return invocation.invoke();
			}
			return "loginUI";
		}
		return invocation.invoke();
	}
	
}
