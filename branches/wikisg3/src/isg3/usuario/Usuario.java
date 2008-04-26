package isg3.usuario;

public class Usuario {
	
	
	/**
	 * Nick del usuario.
	 */
	private String nick;
	
	/**
	 * Contrase�a del usuario.
	 */
	private String pass;
	
	/**
	 * Perfil del usuario.
	 */
	private Perfil perfil;
	
	
	//Metodos getters y setters

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
	
	//Constructor

	public Usuario(String nick, String pass, Perfil perfil) {
		this.nick = nick;
		this.pass = pass;
		this.perfil = perfil;
	}
	
	public Usuario(String nick, String pass){
		this.nick = nick;
		this.pass = pass;
	}
	
	public Usuario(){
		
	}
	
	
	
}