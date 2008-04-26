package isg3.user;

import java.util.Collection;
import java.util.Date;

public class UserProfile {

	private String name;
	
	private String surname;
	
	private Date lastVisit;
	
	private String mail;
	
	private Date registeredDate;
	
	private String language;
	
	private boolean status;
	
	private Collection articles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Collection getArticles() {
		return articles;
	}

	public void setArticles(Collection articles) {
		this.articles = articles;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}
	
	
}
