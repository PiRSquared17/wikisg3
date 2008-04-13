package isg3.operations;

import java.util.Collection;
import isg3.article.*;
import isg3.user.User;

public interface IWikiOperations {

	public void addRate(Rate rate);
	
	public void addArticle(User author, String title, String content, Category cat);
	
	public void editArticle(User editor);
	
	public boolean existsArticle(String name);
	
	public Collection getArticles(String name);
	
	public boolean existsRate(User user, Article art);
	
}
