package service;

import java.util.List;

import pojo.Food;

public interface IFoodService {
	Food getByName(String name);
	List<Food> foundByKeyword(String keyword);
	List<Food> getFoodByShopName(String name);
}
