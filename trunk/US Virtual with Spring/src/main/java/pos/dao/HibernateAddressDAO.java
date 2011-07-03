package pos.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pos.domain.Address;

@Repository
@Service("addressDAO")
public class HibernateAddressDAO implements AddressDAO {

	//tira del bean de sessionFactory
	//definido en hibernate-config.xml
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
	}

	@Override
	public Address getAddress(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Address)session.get(Address.class, id);
	}

}
