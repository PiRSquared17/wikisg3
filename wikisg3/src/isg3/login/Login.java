package isg3.login;
import isg3.user.User;

import java.util.*;



public class Login {

	private Map m;
	
	public void creaUsuarios(){
		m=new HashMap();
		m.put("pepe", "ole");
		m.put("danialves", "lateral");
		m.put("antonio", "sevilla");
		m.put("carlos", "espa�a");
		m.put("mediavida", "mvida");
		m.put("wiki", "alga");
	}
	
	
	public User login(String nick, String pass){
		User u = null;
		if (m.get(nick).equals(pass))
			u = new User();
		return u;
	}
}
