package service;

import java.util.List;

import pojo.Food;
import pojo.Shop;
import pojo.User;

public interface IUserService {
	
	boolean checkLogin(String name,String password);
	boolean registe(User user);
	boolean updateInfo(User user);
	boolean updatePassword(String name,String password);
	boolean updatePicture(String name,String picture);
	String getPicture(String name);
}
