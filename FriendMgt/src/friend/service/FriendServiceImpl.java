package friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friend.dao.BaseDao;
import friend.dao.DTOFriend;

@Service("friendService")
public class FriendServiceImpl implements FriendService{

	@Autowired
	BaseDao baseDao;
	
	@Override
	public void persist(DTOFriend friend) {
		baseDao.persist(friend);
	}

	@Override
	public List<DTOFriend> listFriend() {
		return baseDao.getFriend(DTOFriend.class);
	}

}
