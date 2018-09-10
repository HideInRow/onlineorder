package dao;

import java.util.List;

import pojo.Shop;

public interface IShopDao {
	List<Shop> getShopByAddress(String address);
	Shop getShopById(int id);
	int findCount(String address);
}
