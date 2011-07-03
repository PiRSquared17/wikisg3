package pos.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.domain.Detail;

@Repository
@Service("detailDAO")
@Transactional
public class HibernateDetailDAO implements DetailDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void saveDetail(Detail d) {
		Session session = sessionFactory.getCurrentSession();
		session.save(d);
	}

}
