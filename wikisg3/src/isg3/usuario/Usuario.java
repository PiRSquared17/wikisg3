package isg3.usuario;

public class Usuario {
	
	
	/**
	 * Nick del usuario.
	 */
	private String nick;
	
	/**
	 * Contrase�a del usuario.
	 */
	private String contrase�a;
	
	/**
	 * Perfil del usuario.
	 */
	private Perfil perfil;
	
	
	//Metodos getters y setters

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getNick() {
		return nick;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
	
	//Constructor

	public Usuario(String nick, String contrase�a, Perfil perfil) {
		this.nick = nick;
		this.contrase�a = contrase�a;
		this.perfil = perfil;
	}
	
	public Usuario(String nick, String contrase�a){
		this.nick = nick;
		this.contrase�a = contrase�a;
	}
	
	public Usuario(){
		
	}
	
	
	
}