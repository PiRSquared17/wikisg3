package isg3.usuario;
import java.util.Date;


public class Perfil {
	
	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Apellidos del usuario.
	 */
	private String apellidos;
	
	/**
	 * Fecha de ingreso del usuario.
	 */
	private Date fechaIngreso;
	
	/**
	 * Ultima visita del usuario.
	 */
	private Date ultimaVisita;
	
	/**
	 * Numero de aportaciones del usuario.
	 */
	private int numeroAportaciones;
	
	/**
	 * Direccion de correo del usuario.
	 */
	private String correo;
	
	/**
	 * iD del usuario.
	 */
	private long idUsuario;
	
	/**
	 * Idioma del usuario.
	 */
	private String idioma;
	
	/**
	 * Tema elegido por el usuario.
	 */
	private int tema;
	
	/**
	 * Uso horario del usuario.
	 */
	private String usoHorario;
	
	/**
	 * Pais del usuario.
	 */
	private String pais;
	
	
	
	//Metodos getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

	public int getNumeroAportaciones() {
		return numeroAportaciones;
	}

	public void setNumeroAportaciones(int numeroAportaciones) {
		this.numeroAportaciones = numeroAportaciones;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public String getUsoHorario() {
		return usoHorario;
	}

	public void setUsoHorario(String usoHorario) {
		this.usoHorario = usoHorario;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public long getIdUsuario() {
		return idUsuario;
	}
	
	//Constructor
	
	public Perfil() {
		super();
	}
}
