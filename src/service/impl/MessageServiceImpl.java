package service.impl;

import dao.IMessageDao;
import factory.BeanFactory;
import service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	IMessageDao messagedao = BeanFactory.getInstance("messageDao",IMessageDao.class);
	@Override
	public boolean addMessage(String username, int shopid, String content) {
		return messagedao.addMessage(username, shopid, content);
	}
	
}
