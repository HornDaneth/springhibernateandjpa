package friend.dao;

import java.util.List;

public interface BaseDao {
	
	public void persist(Object obj)throws Exception;
	public <T> List<T> getList(Class<T> clazz)throws Exception;
	public <T> T findObject(Class<T> clazz,int id)throws Exception;
	public <T>void delete(Object obj);
	public <T>void update(Class<T> clazz,Object obj,int id)throws Exception;
}
