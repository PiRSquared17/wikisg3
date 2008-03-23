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
		m.put("carlos", "españa");
		m.put("mediavida", "mvida");
		m.put("wiki", "alga");
	}
	
	
	public Usuario login(String nick, String contraseña){
		Usuario u = null;
		if (m.get(nick).equals(contraseña))
			u = new Usuario();
		return u;
	}
}
