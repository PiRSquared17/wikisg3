package isg3.pruebasDAO;

import java.util.Collection;

import isg3.data.*;
import isg3.article.*;
import isg3.user.*;

public class PruebasArticle {
	
	public void insertArticle(){
		IArticleDAO art_dao = new JDBCArticleDAO();
		IUserDAO u_dao = new JDBCUserDAO();
		ICategoryDAO cat_dao = new JDBCCategoryDAO();
		
		User u = u_dao.select("jesus");
		Category cat = cat_dao.selectByName("Deportes");
		
		Article a = new Article("Betis","uhhhh",cat,u);
		
		boolean b = art_dao.insert(a);
		
		System.out.println("¿Insercion correcta?: "+b);
		
	}
	
	public void selectArticle(){
		IArticleDAO art_dao = new JDBCArticleDAO();
		Article a = art_dao.select("El Padrino");
		
		System.out.println(a.getTitle());
	}
	
	public void updateArticle(){
		IArticleDAO art_dao = new JDBCArticleDAO();
		Article a = art_dao.select("El Padrino");
		
		a.setContent(a.getContent()+" .Gran papel de Marlon Brando");
		boolean b = art_dao.update(a, "jesus");
		a = art_dao.select("El Padrino");
		
		System.out.println(a.getTitle());
		System.out.println(a.getContent());
	}
	
	public void selectLastArticles(){
		IArticleDAO art_dao = new JDBCArticleDAO();
		Collection c = art_dao.selectLastArticles(2);
		
		System.out.println(c.size());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebasArticle pruebas = new PruebasArticle();
		//pruebas.selectArticle();
		//pruebas.insertArticle();
		//pruebas.updateArticle();
		pruebas.selectLastArticles();
	}

}
