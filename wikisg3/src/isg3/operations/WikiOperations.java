package isg3.operations;

import isg3.article.*;
import isg3.user.User;

import java.util.Collection;
import java.util.Iterator;

public class WikiOperations implements IWikiOperations {

	@Override
	public void addArticle(User author, String title, String content,
			Category cat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRate(Rate rate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editArticle(String content, String idArticle) {
		// TODO Auto-generated method stub
		Wiki w = Wiki.getInstance();
		Collection l = w.getListArt();
		Iterator it = l.iterator();
		while (it.hasNext()){
			Article art = (Article)it.next();
			if (art.getTitle().equals(idArticle)){
				art.setContent(content);
			}
		}
	}

	@Override
	public boolean existsArticle(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsRate(User user, Article art) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection getArticles(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection getMostRatedArticles(){
		//Provisional, implementar luego.
		return Wiki.getInstance().getListArt();
	}
	
	@Override
	public Article getArticle(String id){
		Collection arts = Wiki.getInstance().getListArt();
		Article art = null;
		Iterator it = arts.iterator();
		
		while(it.hasNext()){
			Article aux = (Article)it.next();
			if (aux.getTitle().equals(id)){
				art = aux;;
			}
		}
		
		return art;
	}
	
	@Override
	public Collection getAllCategories(){
		Collection c;
		
		c = Wiki.getInstance().getListCat();
		
		return c;
	}
	
	@Override
	public Category getCategory(String id){
		Collection arts = Wiki.getInstance().getListCat();
		Category cat = null;
		Iterator it = arts.iterator();
		
		while(it.hasNext()){
			Category aux = (Category)it.next();
			if (aux.getName().equals(id)){
				cat = aux;
			}
		}
		
		return cat;
	}

}
