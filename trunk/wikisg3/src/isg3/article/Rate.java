package isg3.article;

import isg3.user.*;

public class Rate {

	private int rate;
	
	private String reason;
	
	private User user;

	public Rate(int rate, String reason, User user) {
		this.rate = rate;
		this.reason = reason;
		this.user = user;
	}

	public int getRate() {
		return rate;
	}

	public String getReason() {
		return reason;
	}

	public User getUser() {
		return user;
	}
	
	public boolean equals(Object o){
		boolean b = false;
		if (o instanceof Rate){
			Rate r = (Rate)o;
			if (r.getUser().getNick().equals(this.getUser().getNick())){
				b = true;
			}
		}
		return b;
		
	}
	
	
}
