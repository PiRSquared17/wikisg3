package isg3.operations;

import isg3.article.*;
import isg3.user.User;
import isg3.data.*;

import java.util.Collection;
import java.util.Iterator;

public class WikiOperations implements IWikiOperations {

	private ICategoryDAO cat_dao;
	
	private IArticleDAO art_dao;
	
	private IUserDAO user_dao;
	
	private IRateDAO rate_dao;
	
	public WikiOperations(){
		cat_dao = new JDBCCategoryDAO();
		art_dao = new JDBCArticleDAO();
		user_dao = new JDBCUserDAO();
		rate_dao = new JDBCRateDAO();
	}
	
	@Override
	public void addArticle(User author, String title, String content,
			Category cat) {
		// TODO Auto-generated method stub
		Article a = new Article(title,content,cat,author);
		art_dao.insert(a);
		
	}

	@Override
	public void addRate(String user, String reason, int rate, String title) {
		// TODO Auto-generated method stub
		User u = user_dao.select(user);
		Article art = art_dao.select(title);
		Rate r = new Rate(rate,reason,u);
		//HAY QUE COMPROBAR PRIMERO SI EL USUARIO YA HA
		//VALORADO EL ARTICULO. 
		if (this.existsRate(user, title)){
			rate_dao.update(r, title);
		}
		else{
			rate_dao.insert(r, title);
		}
		
		
		
		/*User u = getUser(user);
		Article art = getArticle(title);
		Rate r = new Rate(rate, reason, u);
		
		if (art.getRates().getRates().contains(r)){
			art.getRates().editRate(r);
		}else{
			art.getRates().addNewRate(r);
		}*/
		

	}

	@Override
	public User getUser(String user){
		
		return user_dao.select(user);
		/*User ret = null;
		Wiki w = Wiki.getInstance();
		Iterator it = w.getListUser().iterator();
		while (it.hasNext()){
			User u = (User)it.next();
			if (u.getNick().equals(user)){
				ret = u;
			}
		}
		return ret;*/
	}
	
	
	@Override
	public void editArticle(String content, String idArticle, String user, Category cat) {
		// TODO Auto-generated method stub
		
		//CUIDADO, ESTE MÉTODO PUEDE FALLAR (POR LA CATEGORIA)
		
		Article art = new Article();
		art.setTitle(idArticle);
		art.setContent(content);
		art.setCat(cat);
		art_dao.update(art, user);
		
		/*Wiki w = Wiki.getInstance();
		Collection l = w.getListArt();
		Iterator it = l.iterator();
		boolean b = false;
		while (it.hasNext() && !b){
			Article art = (Article)it.next();
			if (art.getTitle().equals(idArticle)){
				b = true;
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
		}*/
	}

	
	@Override
	public boolean existsArticle(String name) {
		// PELIGRO, PUEDE FALLAR
		return (art_dao.select(name) != null);
	}

	@Override
	public boolean existsRate(String user, String art) {
		// PELIGRO, PUEDE FALLAR
		return (rate_dao.select(art, user) != null);
	}

	@Override
	public Collection getArticles(String name) {
		Category cat = cat_dao.selectByName(name);
		return cat.getArticles();
	}
	
	@Override
	public Collection getMostRatedArticles(){
		//PROVISIONAL
		return art_dao.selectLastArticles(3);
		//return Wiki.getInstance().getListArt();
	}
	
	@Override
	public Article getArticle(String id){
		
		return art_dao.select(id);
		
		/*Collection arts = Wiki.getInstance().getListArt();
		Article art = null;
		Iterator it = arts.iterator();
		
		while(it.hasNext()){
			Article aux = (Article)it.next();
			if (aux.getTitle().equals(id)){
				art = aux;;
			}
		}
		
		return art;*/
	}
	
	@Override
	public Collection getAllCategories(){
		return cat_dao.selectAll();
	}
	
	@Override
	public Category getCategory(String id){
		
		return cat_dao.selectByName(id);
		
		/*Collection arts = Wiki.getInstance().getListCat();
		Category cat = null;
		Iterator it = arts.iterator();
		
		while(it.hasNext()){
			Category aux = (Category)it.next();
			if (aux.getName().equals(id)){
				cat = aux;
			}
		}
		
		return cat;*/
	}
	
	@Override
	public Rate getRate(String title, String user){
		
		return rate_dao.select(title, user);
		
		/*Rate r = null;
		
		Article ar = this.getArticle(title);
		Iterator it = ar.getRates().getRates().iterator();
		while (it.hasNext() && (r == null)){
			Rate rate = (Rate)it.next();
			if (rate.getUser().getNick().equals(user)){
				r = rate;
			}
		}
		
		return r;*/
	}
	
	public boolean login(String nick, String pass){
		boolean b = false;
		
		User u = user_dao.select(nick);
		if (u != null){
			b = (u.getPass().equals(pass));
		}
		
		return b;
	}
	
	public void editProfile(User user){
		user_dao.update(user);
	}
}
