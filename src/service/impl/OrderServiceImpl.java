package service.impl;

import java.util.List;

import dao.IOrderDao;
import dao.IUserDao;
import factory.BeanFactory;
import service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	IOrderDao orderdao = BeanFactory.getInstance("orderDao", IOrderDao.class);
	@Override
	public boolean addOrder(int foodid, String username, int count) {
		// TODO Auto-generated method stub
		return orderdao.insertOrder(foodid, username, count);
	}
	@Override
	public double getMoney(int foodid, int count) {
		return orderdao.getMoney(foodid, count);
	}
	@Override
	public List<Integer> getShopid(String username) {
		return orderdao.getShopId(username);
	}

}
