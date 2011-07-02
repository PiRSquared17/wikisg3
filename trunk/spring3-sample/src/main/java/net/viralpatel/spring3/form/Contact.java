package net.viralpatel.spring3.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4531953881018832745L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LAST_NAME") 
    private String lastname;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "TELEPHONE")
    private String telephone;
    
    public Integer getId(){
    	return id;
    }
    
    public void setId(Integer id){
    	this.id = id;
    }
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    
    
	
}
