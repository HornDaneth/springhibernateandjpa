package friend.dao;

import java.util.List;

public interface BaseDao {
	
	public void persist(Object obj);
	public <T> List<T> getFriend(Class<T> clazz);
	public <T> T findFriend(Class<T> clazz,int id);
	public <T>void delete(Object obj);
	public void update(DTOFriend friend);
}
