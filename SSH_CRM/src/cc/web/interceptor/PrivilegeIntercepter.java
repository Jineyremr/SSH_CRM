package cc.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cc.domain.User;

public class PrivilegeIntercepter extends MethodFilterInterceptor{

	@Override
	//��У��login��register����
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//���session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//��õ�¼��ʶ
		User user = (User) session.get("user");
		//�жϱ�ʾ�Ƿ����
		if(user!=null){
			return invocation.invoke();
		}else{
			return "toLogin";
		}
		
	}

}
