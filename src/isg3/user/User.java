package isg3.user;

import isg3.mailBox.*;

public class User extends AbstractUser{

	private String nick;
	
	private String password;
	
	private MailBox mailbox;
	
	private UserProfile profile;

	public String getNick() {
		return nick;
	}

	public MailBox getMailbox() {
		return mailbox;
	}

	public UserProfile getProfile() {
		return profile;
	}

	public void setPassword(String password) {
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
	
	public User(String nick, String pass){
		this.nick=nick;
		this.password=pass;
	}
	
	public User(){
		
	}
	
}
