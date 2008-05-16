package isg3.operations;

import java.util.Collection;
import isg3.article.*;
import isg3.user.User;

public interface IWikiOperations {
	
	public Category getCategory(String id);
	
	public Collection getAllCategories();
	
	public void addRate(Rate rate);
	
	public void addArticle(User author, String title, String content, Category cat);
	
	public void editArticle(String content,  String idArticle);
	
	public boolean existsArticle(String name);
	
	public Collection getArticles(String name);
	
	public Article getArticle(String oid);
	
	public boolean existsRate(User user, Article art);
	
	public Collection getMostRatedArticles();
	
}
