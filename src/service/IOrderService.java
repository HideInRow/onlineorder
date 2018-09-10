package service;

import java.util.List;

public interface IOrderService {
	boolean addOrder(int foodid, String username,int count);
	double getMoney(int foodid,int count);
	List<Integer> getShopid(String username);
}
