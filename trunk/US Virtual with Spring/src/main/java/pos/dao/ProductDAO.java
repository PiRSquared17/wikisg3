package pos.dao;

import java.util.List;

import pos.domain.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();
	
	public Product getProduct(Integer id);
	
}
