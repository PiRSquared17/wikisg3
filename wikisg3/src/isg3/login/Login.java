package login;
import isg3.usuario.Usuario;

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
	
	
	public Usuario login(String nick, String contrase�a){
		Usuario u = null;
		if (m.get(nick).equals(contrase�a))
			u = new Usuario();
		return u;
	}
}
