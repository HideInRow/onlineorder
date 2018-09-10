package service.impl;

import java.util.List;

import dao.IShopDao;
import dao.IUserDao;
import factory.BeanFactory;
import pojo.Shop;
import service.IShopService;

public class ShopServiceImpl implements IShopService{
	IShopDao shopdao = BeanFactory.getInstance("shopDao", IShopDao.class);
	@Override
	public List<Shop> foundShopByAddress(String shopaddress) {
		
		return shopdao.getShopByAddress(shopaddress);
	}

	@Override
	public Shop getShopById(int id) {
		return shopdao.getShopById(id);
	}

	@Override
	public int findCount(String address) {
		return shopdao.findCount(address);
	}
}
