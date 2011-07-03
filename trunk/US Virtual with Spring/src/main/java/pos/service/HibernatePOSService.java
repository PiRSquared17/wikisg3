package pos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.dao.AddressDAO;
import pos.dao.CreditCardDAO;
import pos.dao.ProductDAO;
import pos.domain.Address;
import pos.domain.CreditCard;
import pos.domain.Product;

@Service("posService")
@Transactional
public class HibernatePOSService implements POSService {

	//XXX si peta usando la interfaz, pasar a la implementacion
	
	@Resource(name="addressDAO")
	private AddressDAO addressDAO;
	
	@Resource(name="productDAO")
	private ProductDAO productDAO;
	
	@Resource(name = "creditCardDAO")
	private CreditCardDAO creditCardDAO;
	
	
	@Override
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

}
