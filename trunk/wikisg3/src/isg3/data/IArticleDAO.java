package isg3.data;

import java.util.Collection;

import isg3.article.Article;
import isg3.article.Category;

public interface IArticleDAO {
	
	public Collection getAllArticles(Category cat);
	public boolean insert(Article a);
	public boolean update(Article a);
	public Article select(String title);
	public boolean remove(String title);
	public Collection selectAll();
	public Collection selectMostRatedArticles();
	
}
