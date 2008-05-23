package isg3.user;

import isg3.mailBox.*;

public class User extends AbstractUser{

	private String nick;
	
	private String password;
	
	private MailBox mailbox;
	
	private UserProfile profile;

	public User(String nick, String pass){
		this.nick=nick;
		this.password=pass;
		this.profile = new UserProfile();
	}
	
	public User(String nick, String pass, UserProfile p){
		this.nick=nick;
		this.password=pass;
		this.profile = p;
	}
	
	public User(){
		this.profile = new UserProfile();
	}
	
	public String getPass(){
		return this.password;
	}
	
	public String getNick() {
		return nick;
	}

	public MailBox getMailbox() {
		return mailbox;
	}

	public UserProfile getProfile() {
		return profile;
	}
	
	public void setProfile(UserProfile p){
		this.profile = p;
	}

	public void setNick(String nick){
		this.nick = nick;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	//¿usuario iguales si nick igual?
	public boolean equals(Object o){
		boolean b = false;
		User usr = (User)o;
		
		if (this.nick.equals(usr.getNick())){
			b = true;
		}
		
		return b;
	}
	
	
	
}
