package isg3.user;

import isg3.mailBox.*;

public class RegisteredUser extends User{

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
	
	
}
