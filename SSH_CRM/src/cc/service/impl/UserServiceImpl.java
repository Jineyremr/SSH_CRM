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
			throw new RuntimeException("�û��������ڣ�");
		}
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("�������");
		}
		return existU;
	}

	public void regist(User user) {
		//����ע������ѯ�û�
		User regist = ud.login(user.getUser_code());
		//����û����ڣ��׳��쳣
		if(regist!=null){
			throw new RuntimeException("�û����Ѿ�����!");
		}else{
			//����û������ڣ������û�
			ud.save(user);
		}
		
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
	
}
