package isg3.articulo;

import java.util.*;

public class Categoria {
	
	/**
	 * Nombre de la categoria.
	 */
	private String nombre;
	
	/**
	 * Descripcion de la categoria.
	 */
	private String descripcion;
	
	/**
	 * Conjunto de los articulos de la categoria.
	 */
	Collection articulos;

	
	//Metodos getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public Collection getArticulos() {
		return articulos;
	}
	
	//Otros metodos
	
	public void addArticulo(Articulo a){
		articulos.add(a);
	}

	
	//Constructor
	
	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		articulos = new ArrayList();
	}


	
	
	
	
}
