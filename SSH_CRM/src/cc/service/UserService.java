package cc.service;

import cc.domain.User;

public interface UserService {
	//用户登录
	User login(User u);
	//用户注册
	void save(User u);
}
