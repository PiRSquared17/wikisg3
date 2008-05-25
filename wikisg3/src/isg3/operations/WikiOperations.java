package isg3.operations;

import isg3.article.*;
import isg3.mailBox.Message;
import isg3.user.User;
import isg3.data.*;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class WikiOperations implements IWikiOperations {

	private ICategoryDAO cat_dao;
	
	private IArticleDAO art_dao;
	
	private IUserDAO user_dao;
	
	private IRateDAO rate_dao;
	
	private IMessageDAO message_dao;
	
	/*public WikiOperations(){
		cat_dao = new JDBCCategoryDAO();
		art_dao = new JDBCArticleDAO();
		user_dao = new JDBCUserDAO();
		rate_dao = new JDBCRateDAO();
		message_dao = new JDBCMessageDAO();
	}*/
	
	@Override
	public void addArticle(User author, String title, String content,
			Category cat) {
		// TODO Auto-generated method stub
		art_dao = new JDBCArticleDAO();
		Article a = new Article(title,content,cat,author);
		art_dao.insert(a);
		
	}

	@Override
	public void addRate(String user, String reason, int rate, String title) {
		// TODO Auto-generated method stub
		art_dao = new JDBCArticleDAO();
		user_dao = new JDBCUserDAO();
		rate_dao = new JDBCRateDAO();
		
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
		
	}

	@Override
	public User getUser(String user){
		user_dao = new JDBCUserDAO();
		return user_dao.select(user);

	}
	
	
	@Override
	public void editArticle(String content, String idArticle, String user, Category cat) {
		// TODO Auto-generated method stub
		
		//CUIDADO, ESTE MÉTODO PUEDE FALLAR (POR LA CATEGORIA)
		art_dao = new JDBCArticleDAO();
		
		Article art = new Article();
		art.setTitle(idArticle);
		art.setContent(content);
		art.setCat(cat);
		art_dao.update(art, user);
		
	}

	
	@Override
	public boolean existsArticle(String name) {
		// PELIGRO, PUEDE FALLAR
		art_dao = new JDBCArticleDAO();
		return (art_dao.select(name) != null);
	}

	@Override
	public boolean existsRate(String user, String art) {
		// PELIGRO, PUEDE FALLAR
		rate_dao = new JDBCRateDAO();
		return (rate_dao.select(art, user) != null);
	}

	@Override
	public Collection getArticles(String name) {
		cat_dao = new JDBCCategoryDAO();
		Category cat = cat_dao.selectByName(name);
		return cat.getArticles();
	}
	
	@Override
	public Collection getMostRatedArticles(){
		//PROVISIONAL
		art_dao = new JDBCArticleDAO();
		return art_dao.selectLastArticles(5);
	}
	
	@Override
	public Article getArticle(String id){
		art_dao = new JDBCArticleDAO();
		return art_dao.select(id);
		
	}
	
	@Override
	public Collection getAllCategories(){
		cat_dao = new JDBCCategoryDAO();
		return cat_dao.selectAll();
	}
	
	@Override
	public Category getCategory(String id){
		cat_dao = new JDBCCategoryDAO();
		return cat_dao.selectByName(id);

	}
	
	@Override
	public Rate getRate(String title, String user){
		rate_dao = new JDBCRateDAO();
		return rate_dao.select(title, user);

	}
	
	public boolean login(String nick, String pass){
		boolean b = false;
		user_dao = new JDBCUserDAO();
		User u = user_dao.select(nick);
		if (u != null){
			b = (u.getPass().equals(pass));
		}
		
		return b;
	}
	
	public void editProfile(User user){
		user_dao = new JDBCUserDAO();
		user_dao.update(user);
	}
	
	public Collection searchArticle(String article){
		art_dao = new JDBCArticleDAO();
		Collection c = art_dao.search(article);
		return c;
	}
	
	public Collection getAllMessages(String user){
		message_dao = new JDBCMessageDAO();
		Collection c;
		c = message_dao.selectAllReceived(user);
		return c;
	}
	
	public Message getMessage(String idMessage){
		message_dao = new JDBCMessageDAO();
		Message m = message_dao.select(idMessage);
		return m;
		
	}
	
	public boolean removeMessage(String idMessage){
		message_dao = new JDBCMessageDAO();
		boolean b = message_dao.delete(idMessage);
		return b;
	}
	
	public boolean sendMessage(String userFrom, String userTo, String subject, String content){
		message_dao = new JDBCMessageDAO();
		Message m = new Message(userFrom, userTo, subject, content, new Date());
		boolean b = message_dao.insert(m);
		return b;
	}

	@Override
	public void setUnderDiscussion(String title, String user) {
		// TODO Auto-generated method stub
		art_dao = new JDBCArticleDAO();
		Article art = this.art_dao.select(title);
		art.setUnderDiscussion(true);
		this.art_dao.update(art, user);
	}
}
