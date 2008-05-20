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
	public void addRate(String user, String reason, int rate, String title) {
		// TODO Auto-generated method stub

		User u = getUser(user);
		Article art = getArticle(title);
		Rate r = new Rate(rate, reason, u);
		
		if (art.getRates().getRates().contains(r)){
			art.getRates().editRate(r);
		}else{
			art.getRates().addNewRate(r);
		}
		

	}

	@Override
	public User getUser(String user){
		User ret = null;
		Wiki w = Wiki.getInstance();
		Iterator it = w.getListUser().iterator();
		while (it.hasNext()){
			User u = (User)it.next();
			if (u.getNick().equals(user)){
				ret = u;
			}
		}
		return ret;
	}
	
	
	@Override
	public void editArticle(String content, String idArticle, String user) {
		// TODO Auto-generated method stub
		Wiki w = Wiki.getInstance();
		Collection l = w.getListArt();
		Iterator it = l.iterator();
		while (it.hasNext()){
			Article art = (Article)it.next();
			if (art.getTitle().equals(idArticle)){
				art.setContent(content);
				User u = getUser(user);
				//añadimos al articulo el usuario que 
				//lo ha editado
				art.getUsersEditors().add(u);
				//guardamos en el perfil del usuario el articulo 
				//que ha editado
				//u.getProfile().getArticles().add(art);
				//Collection c = u.getProfile().getArticles();
				Collection c2 = art.getUsersEditors();
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
	
	@Override
	public Rate getRate(String title, String user){
		Rate r = null;
		
		Article ar = this.getArticle(title);
		Iterator it = ar.getRates().getRates().iterator();
		while (it.hasNext() && (r == null)){
			Rate rate = (Rate)it.next();
			if (rate.getUser().getNick().equals(user)){
				r = rate;
			}
		}
		
		return r;
	}

}
