package isg3.articulo;

public class Valoracion {
	
	/**
	 * Justificacion de la nota.
	 */	
	private String razon;
	
	/**
	 * Nota aportada por el usuario.
	 */
	private int nota;

	
	//Metodos getters y setters
	
	public String getRazon() {
		return razon;
	}

	public int getNota() {
		return nota;
	}

	
	//Constructor

	public Valoracion(String razon, int nota) {
		this.razon = razon;
		this.nota = nota;
	}

	
}
