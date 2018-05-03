package cc.dao;

import cc.domain.User;

public interface UserDao extends BaseDao<User>{
	
	User login (String userCode);

	
}
