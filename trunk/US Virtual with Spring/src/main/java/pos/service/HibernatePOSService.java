package pos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pos.dao.AddressDAO;
import pos.dao.CreditCardDAO;
import pos.dao.DetailDAO;
import pos.dao.OrderDAO;
import pos.dao.ProductDAO;
import pos.domain.Address;
import pos.domain.CreditCard;
import pos.domain.Detail;
import pos.domain.Order;
import pos.domain.Product;

@Service("posService")
public class HibernatePOSService implements POSService {
	
	@Resource(name="addressDAO")
	private AddressDAO addressDAO;
	
	@Resource(name="productDAO")
	private ProductDAO productDAO;
	
	@Resource(name = "creditCardDAO")
	private CreditCardDAO creditCardDAO;
	
	@Resource(name = "orderDAO")
	private OrderDAO orderDAO;
	
	@Resource(name = "detailDAO")
	private DetailDAO detailDAO;
	

	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProduct(Integer id) {
		return productDAO.getProduct(id);
	}

	@Override
	public CreditCard getCreditCard(Integer id) {
		return creditCardDAO.getCreditCard(id);
	}

	@Override
	public void saveCreditCard(CreditCard c) {
		creditCardDAO.saveCreditCard(c);
	}

	@Override
	public Address getAddress(Integer id) {
		return addressDAO.getAddress(id);
	}

	@Override
	public void saveAddress(Address address) {
		addressDAO.saveAddress(address);
	}

	@Override
	public void saveOrder(Order o) {
		this.saveAddress(o.getDeliverto());
		this.saveCreditCard(o.getPayment());
		orderDAO.saveOrder(o);
		List<Detail> details = o.getDetails();
		for (Detail d:details){
			this.saveDetail(d);
		}
	}

	@Override
	public void saveDetail(Detail d) {
		detailDAO.saveDetail(d);
	}

}
