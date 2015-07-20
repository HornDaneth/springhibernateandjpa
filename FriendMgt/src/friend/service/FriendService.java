package friend.service;

import java.util.List;

import friend.model.DTOFriend;

public interface FriendService {
	public DTOFriend persist(DTOFriend friend);
	public List<DTOFriend>  listFriend();
	public DTOFriend findFriend(int id);
	public DTOFriend delete(Object obj);
	public DTOFriend update(DTOFriend friend);
}
