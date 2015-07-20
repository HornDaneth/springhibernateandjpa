package friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friend.dao.BaseDao;
import friend.model.DTOFriend;

@Service("friendService")
public class FriendServiceImpl implements FriendService{

	@Autowired
	BaseDao baseDao;
	
	@Override
	public DTOFriend persist(DTOFriend friend){
		try {
			baseDao.persist(friend);
			return friend;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DTOFriend> listFriend() {
		try {
			return baseDao.getList(DTOFriend.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DTOFriend findFriend(int id) {
		DTOFriend friend;
		try {
			friend = baseDao.findObject(DTOFriend.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return friend;
	}

	@Override
	public DTOFriend delete(Object obj) {
		try{
			baseDao.delete(obj);
			return (DTOFriend)obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public DTOFriend update(DTOFriend friend){
		try {
			baseDao.update(DTOFriend.class,friend,friend.getNUM());
			return friend;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
