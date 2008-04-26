package isg3.article;

import isg3.user.*;

public class ArticleFactory {

	/**
	 * 
	 * @param title
	 * @param content
	 * @param user
	 * @return
	 */
	public Article createArticle(String title, String content, Category cat, User user){
		
		return new Article(title, content, cat, user);
		
	}
	
}
