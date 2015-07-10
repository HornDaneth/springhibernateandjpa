package friend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
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

}
