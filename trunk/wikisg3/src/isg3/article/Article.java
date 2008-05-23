package isg3.article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import isg3.user.*;
 
public class Article {
	
	private String title;
	
	private String content;
	
	private Date lastRevision;
	
	private long visits;
	
	private Category cat;
	
	Collection usersEditor;
	
	RatesCollection rates;

	public Article(){
		
	}
	
	public Article(String title, String content, Category cat, User user) {
		this.title = title;
		this.content = content;
		this.cat = cat;
		this.visits = 0;
		this.rates = new RatesCollection();
		usersEditor = new ArrayList();
		usersEditor.add(user);
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
	
	public void setTitle(String t){
		this.title = t;
	}

	public Date getLastRevision() {
		return lastRevision;
	}
	
	public void setLastRevision(Date d){
		this.lastRevision = d;
	}

	public long getVisits() {
		return visits;
	}
	
	public void setVisits(long v){
		this.visits = v;
	}

	public Category getCat() {
		return cat;
	}
	
	public void setCat(Category cat){
		this.cat = cat;
	}

	public Collection getUsersEditors() {
		return usersEditor;
	}
	
	public void setUSersEditors(Collection c){
		this.usersEditor = c;
	}

	public boolean hasRates(){
		boolean b = false;
		if (rates.getRates().size()>0)
			b = true;
		return b;
	}
	
	public RatesCollection getRates() {
		return rates;
	}
	
	public void setRatesCollection(RatesCollection c){
		this.rates = c;
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
