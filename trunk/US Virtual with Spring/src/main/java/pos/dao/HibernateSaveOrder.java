package pos.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.domain.Order;

@Repository
@Service("orderDAO")
@Transactional
public class HibernateSaveOrder implements OrderDAO {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrder(Order o) {
		Session session = sessionFactory.getCurrentSession();
		session.save(o);
	}

}
