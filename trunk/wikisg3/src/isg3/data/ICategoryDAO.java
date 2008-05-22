package isg3.data;

import java.util.Collection;

import isg3.article.Category;

public interface ICategoryDAO {

	public Category select(String name);
	public Collection selectAll();
	public Collection selectAllArticles(String catName);
	
}
