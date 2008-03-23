package isg3.articulo;

public class Categoria {
	
	/**
	 * Nombre de la categoria.
	 */
	private String nombre;
	
	/**
	 * Descripcion de la categoria.
	 */
	private String descripcion;

	
	//Metodos getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	
	//Constructor
	
	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	
	
}
