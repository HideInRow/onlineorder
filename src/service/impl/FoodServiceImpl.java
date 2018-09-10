package service.impl;

import java.util.List;

import dao.IFoodDao;
import dao.IUserDao;
import factory.BeanFactory;
import pojo.Food;
import service.IFoodService;

public class FoodServiceImpl implements IFoodService {
	IFoodDao fooddao = BeanFactory.getInstance("foodDao",IFoodDao.class);
	@Override
	public Food getByName(String name) {
		Food food = fooddao.findByName(name);
		return food;
	}
	

	public List<Food> foundByKeyword(String keyword) {
		List<Food> foods = fooddao.getFoodByKeyword(keyword);
		return foods;
	}

	@Override
	public List<Food> getFoodByShopName(String name) {
		// TODO Auto-generated method stub
		return fooddao.getFoodByShopName(name);
	}

}
