package service.impl;

import java.util.List;

import dao.IUserDao;
import factory.BeanFactory;
import pojo.Food;
import pojo.Shop;
import pojo.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userdao = BeanFactory.getInstance("userDao", IUserDao.class);
	

	

	
	public boolean checkLogin(String name, String password) {
		return userdao.checkUser(name, password);
	}

	@Override
	public boolean registe(User user) {
		return userdao.addUser(user);
	}

	@Override
	public boolean updateInfo(User user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}

	@Override
	public boolean updatePassword(String name, String password) {
		// TODO Auto-generated method stub
		return userdao.updatePassword(name, password);
	}

	@Override
	public boolean updatePicture(String name, String picture) {
		// TODO Auto-generated method stub
		return userdao.updatePicture(name, picture);
	}
	
	@Override
	public String getPicture(String name) {
		// TODO Auto-generated method stub
		return userdao.findPicture(name);
	}

	

}
