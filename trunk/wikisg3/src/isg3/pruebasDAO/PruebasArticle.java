package isg3.pruebasDAO;

import isg3.data.*;
import isg3.article.*;

public class PruebasArticle {
	
	public void insertArticle(){
		
	}
	
	public void selectArticle(){
		IArticleDAO art_dao = new JDBCArticleDAO();
		Article a = art_dao.select("El Padrino");
		
		System.out.println(a.getTitle());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebasArticle pruebas = new PruebasArticle();
		pruebas.selectArticle();
	}

}
