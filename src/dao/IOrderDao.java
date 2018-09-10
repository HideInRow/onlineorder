package dao;

import java.util.List;

public interface IOrderDao {
	boolean insertOrder(int foodid,String username,int count);
	double getMoney(int foodid,int count);
	List<Integer> getShopId(String name);
}
