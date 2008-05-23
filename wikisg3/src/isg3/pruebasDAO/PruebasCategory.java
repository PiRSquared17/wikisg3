package isg3.pruebasDAO;

import isg3.data.*;
import isg3.article.*;

public class PruebasCategory {
	
	public void selectCategory(){
		ICategoryDAO cat_dao = new JDBCCategoryDAO();
		Category cat = cat_dao.selectByName("Deportes");
		
		System.out.println(cat.getDescription());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebasCategory pruebas = new PruebasCategory();
		pruebas.selectCategory();
	}

}
