package cc.service;

import cc.domain.User;

public interface UserService {
	//�û���¼
	User login(User u);
	//�û�ע��
	void save(User u);
}
