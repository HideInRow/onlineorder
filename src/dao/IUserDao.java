package dao;

import java.util.List;

import pojo.Food;
import pojo.Shop;
import pojo.User;

public interface IUserDao {
	boolean addUser(User user);
	boolean delUser(int id);
	boolean updateUser(User user);
	boolean checkUser(String name,String password);
	boolean updatePassword(String name,String password);
	boolean updatePicture(String name,String picture);
	String findPicture(String name);
}
