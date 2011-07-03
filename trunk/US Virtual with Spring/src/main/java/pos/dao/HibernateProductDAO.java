package pos.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.domain.Product;

@Repository
@Service("productDAO")
@Transactional
public class HibernateProductDAO implements ProductDAO {

	
	@Resource(name = "sessionFactory")
	//@Autowired
	private SessionFactory sessionFactory;
	
	@Override
//	@Transactional
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("From Product");
		return q.list();
	}

	@Override
	public Product getProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Product)session.get(Product.class, id);
	}

}
