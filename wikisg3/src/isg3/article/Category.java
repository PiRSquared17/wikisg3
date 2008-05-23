package isg3.article;

import java.util.Collection;

public class Category {

	private String name;
	
	private String description;
	
	private Collection articles;

	public Category(){
		
	}
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setArticles(Collection c){
		this.articles = c;
	}

	public Collection getArticles() {
		return articles;
	}
	
	
	
}
