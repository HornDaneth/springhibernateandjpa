package friend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository (value="BaseDao")
@Transactional
public class BaseImpDao implements BaseDao{

	// An EntityManager will be automatically injected from EntityManagerFactory setup on
	// spring-context.xml
	@PersistenceContext
	private EntityManager em;
	
	
	//Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
	// any bean method annotated with @Transactional will cause Spring to magically call
	// begin() and commit() at the start/end of the method. If exception occurs it will also
	// call rollback()
	@Override
	public void persist(Object obj) {
		em.persist(obj);
	}

	@Override
	
	public <T> List<T> getFriend(Class<T> clazz) {
		TypedQuery<T> query= em.createQuery(" from "+ clazz.getName(),clazz);
		return query.getResultList();
	}

	@Override
	public <T> T findFriend(Class<T> clazz,int id) {
		T obj = em.find(clazz, id);
		return obj;
	}

	@Override
	public void delete(Object ob) {
		ob=em.merge(ob); //merge and assign a to the attached entity
		em.remove(ob); // remove the attached entity
		
	}
	
	@Override
	public void update(DTOFriend friend){
		DTOFriend o= findFriend(DTOFriend.class, friend.getNUM());
		o.setNAMES(friend.getNAMES());
		o.setTEL(friend.getTEL());
		o.setADDR(friend.getADDR());
		em.merge(o);
	}
}
