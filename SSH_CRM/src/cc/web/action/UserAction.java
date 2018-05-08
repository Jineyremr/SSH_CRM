package cc.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cc.domain.User;
import cc.service.UserService;
import cc.utils.MD5Utils;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	User user = new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login(){
		//调用service层整形登录逻辑
		User u = userService.login(user);
		//将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);	
		
		return "toHome";
		
		//System.out.println(userService);
		
		/*u.setUser_code("plus");
		u.setUser_name("加");
		u.setUser_password("1234");
		userService.save(u);*/
		
	}
	
	public String regist(){
		try {
			//调用service保存用户
			user.setUser_password(MD5Utils.md5(user.getUser_password()));
			userService.regist(user);
			//重定向至登录页面
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//重定向至登录页面
		return "toLogin";
		
	}
	

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
	
}
