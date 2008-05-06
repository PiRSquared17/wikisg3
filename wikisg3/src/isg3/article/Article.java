package isg3.article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import isg3.user.*;
import isg3.utils.*;
 
public class Article {

	private String oid;
	
	private String title;
	
	private String content;
	
	private Date lastRevision;
	
	private long visits;
	
	private Category cat;
	
	Collection usersEditor;
	
	RatesCollection rates;

	public Article(String title, String content, Category cat, User user) {
		this.title = title;
		this.content = content;
		this.cat = cat;
		this.visits = 0;
		this.rates = new RatesCollection();
		usersEditor = new ArrayList();
		usersEditor.add(user);
		oid = UIDGenerator.getInstance().getKey();
	}

	public String getOID(){
		return this.oid;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public Date getLastRevision() {
		return lastRevision;
	}

	public long getVisits() {
		return visits;
	}

	public Category getCat() {
		return cat;
	}

	public Collection getUsersEditors() {
		return usersEditor;
	}

	public RatesCollection getRates() {
		return rates;
	}
	
	//implementar el equals. ¿como decidir si dos artículos son iguales?
	//en principio por el titulo
	public boolean equals(Object o){
		boolean b = false;
		Article a = (Article)o;
		
		if (this.title.equals(a.getTitle())){
			b = true;
		}
		
		return b;
	}
	
	
}
