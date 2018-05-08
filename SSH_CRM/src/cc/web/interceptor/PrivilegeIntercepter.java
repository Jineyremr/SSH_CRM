package cc.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cc.domain.User;

public class PrivilegeIntercepter extends MethodFilterInterceptor{

	@Override
	//不校验login和register方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获得登录标识
		User user = (User) session.get("user");
		//判断表示是否存在
		if(user!=null){
			return invocation.invoke();
		}else{
			return "toLogin";
		}
		
	}

}
