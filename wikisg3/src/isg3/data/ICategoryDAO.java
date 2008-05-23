package isg3.data;

import java.util.Collection;

import isg3.article.Category;

public interface ICategoryDAO {

	public Category selectByName(String name);
	public Category selectByOID(String oid);
	public Collection selectAll();
	public Collection selectAllArticles(String catName);
	
}
