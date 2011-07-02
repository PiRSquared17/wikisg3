package pos.data;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import pos.domain.Product;

public class ProbandoConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List products = (new JDBCProductDAO()).selectAllProducts();
		
		for (Iterator iter = products.iterator(); iter.hasNext();) {
			Product element = (Product) iter.next();
			
			System.out.println(element.getDescription());
			
		}

	}

}
