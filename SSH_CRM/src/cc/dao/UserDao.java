package cc.dao;

import cc.domain.User;

public interface UserDao {
	
	User login (String userCode);

	void save(User u);
	
}
