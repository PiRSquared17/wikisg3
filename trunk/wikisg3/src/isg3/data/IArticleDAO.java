package isg3.data;

import java.util.Collection;

import isg3.article.Article;
import isg3.article.Category;

public interface IArticleDAO {
	
	public Collection selectAllArticles(Category cat);
	public boolean insert(Article a);
	public boolean update(Article a, String nick);
	public Article select(String title);
	public boolean remove(String title);
	public Collection selectAll();
	public Collection selectMostRatedArticles();
	
}
