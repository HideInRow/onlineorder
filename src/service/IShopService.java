package service;

import java.util.List;

import pojo.Shop;

public interface IShopService {
	List<Shop> foundShopByAddress(String shopaddress);
	Shop getShopById(int id);
	int findCount(String address);
}
