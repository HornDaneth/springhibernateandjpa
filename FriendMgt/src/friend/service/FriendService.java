package friend.service;

import java.util.List;

import friend.dao.DTOFriend;

public interface FriendService {
	public void persist(DTOFriend friend);
	public List<DTOFriend>  listFriend();
	public DTOFriend findFriend(int id);
	public void delete(Object obj);
	public void update(DTOFriend friend);
}
