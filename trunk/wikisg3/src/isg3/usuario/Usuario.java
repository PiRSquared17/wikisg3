package isg3.usuario;

public class Usuario {
	
	
	/**
	 * Nick del usuario.
	 */
	private String nick;
	
	/**
	 * Contraseña del usuario.
	 */
	private String contraseña;
	
	/**
	 * Perfil del usuario.
	 */
	private Perfil perfil;
	
	
	//Metodos getters y setters

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNick() {
		return nick;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
	
	//Constructor

	public Usuario(String nick, String contraseña, Perfil perfil) {
		this.nick = nick;
		this.contraseña = contraseña;
		this.perfil = perfil;
	}
	
	public Usuario(String nick, String contraseña){
		this.nick = nick;
		this.contraseña = contraseña;
	}
	
	public Usuario(){
		
	}
	
	
	
}