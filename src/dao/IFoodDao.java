package dao;

import java.util.List;

import pojo.Food;

public interface IFoodDao {
	List<Food> getAllFood();
	Food findByName(String name);
	List<Food> getFoodByKeyword(String keyword);
	List<Food> getFoodByShopName(String name);
}
