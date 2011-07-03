package pos.service;

import java.util.List;

import pos.domain.Address;
import pos.domain.CreditCard;
import pos.domain.Product;

public interface POSService {

	public List<Product> getAllProducts();
	public Product getProduct(Integer id);
	
	public CreditCard getCreditCard(Integer id);
	public void saveCreditCard(CreditCard c);
	
	public Address getAddress(Integer id);
	public void saveAddress(Address address);
	
}
