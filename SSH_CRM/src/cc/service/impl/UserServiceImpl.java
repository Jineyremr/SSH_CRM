package cc.service.impl;

import cc.dao.UserDao;
import cc.domain.User;
import cc.service.UserService;
import cc.utils.MD5Utils;

public class UserServiceImpl implements UserService {

	private UserDao ud;
	
	public User login(User u) {
		User existU = ud.login(u.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	public void regist(User user) {
		//根据注册名查询用户
		User regist = ud.login(user.getUser_code());
		//如果用户存在，抛出异常
		if(regist!=null){
			throw new RuntimeException("用户名已经存在!");
		}else{
			//如果用户不存在，保存用户
			ud.save(user);
		}
		
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
	
}
