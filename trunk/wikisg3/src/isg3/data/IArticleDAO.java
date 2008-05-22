package isg3.data;

import java.util.Collection;

import isg3.article.Article;

public interface IArticleDAO {
	
	public boolean insert(Article a);
	public boolean update(Article a);
	public Article select(String title);
	public boolean remove(String title);
	public Collection selectAll();
	public Collection selectMostRatedArticles();
	
}
