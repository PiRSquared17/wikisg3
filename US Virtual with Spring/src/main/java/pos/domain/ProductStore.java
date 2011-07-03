package pos.domain;

import java.util.Iterator;
import java.util.List;

import pos.data.JDBCProductDAO;

public class ProductStore {

    private static ProductStore ps;

    private List products;

    public static synchronized ProductStore getInstance() {
        if (ps == null)
            ps = new ProductStore();
        return ps;
    }

    private ProductStore() {
        products = (new JDBCProductDAO()).selectAllProducts();
    }

    public List getProducts() {
        return products;
    }

    public Product getProduct(String productID) {
        Product result = null;
        for (Iterator iter = products.iterator(); iter.hasNext();) {
            Product p = (Product) iter.next();
            if (p.getId().compareTo(productID) == 0) {
                result = p;
            }
        }
        return result;
    }
}
