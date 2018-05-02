package cc.service.impl;

import cc.dao.UserDao;
import cc.domain.User;
import cc.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao ud;
	
	public User login(User u) {
		User existU = ud.login(u.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	public void save(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
	
}
