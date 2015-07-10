package friend.service;

import java.util.List;

import friend.dao.DTOFriend;

public interface FriendService {
	public void persist(DTOFriend friend);
	public List<DTOFriend>  listFriend();
}
