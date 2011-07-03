package pos.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.domain.CreditCard;

@Repository
@Service("creditCardDAO")
@Transactional
public class HibernateCreditCardDAO implements CreditCardDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCreditCard(CreditCard c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
	}

	@Override
	public CreditCard getCreditCard(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (CreditCard)session.get(CreditCard.class, id);
	}

}
