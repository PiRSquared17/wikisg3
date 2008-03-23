package isg3.articulo;
import java.util.*;


public class Articulo {
	/**
	 * Titulo del articulo.
	 */
	private String titulo;
	
	/**
	 * Contenido del articulo.
	 */
	private String contenido;
	
	/**
	 * Fecha de creacion del articulo.
	 */
	private Date fecha;
	
	/**
	 * Numero de lecturas del articulo.
	 */
	private long lecturas;
	
	/**
	 * Coleccion de usuarios que han modificado el articulo.
	 */
	private Collection usuariosMod;
	
	/**
	 * Categoria a la que pertenece el articulo.
	 */
	private Categoria categoria;
	
	/**
	 * Conjunto de valoraciones del articulo.
	 */
	private Collection valoraciones;
	
	
	
	//Metodos getters and setters

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public long getLecturas() {
		return lecturas;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Collection getUsuariosMod() {
		return usuariosMod;
	}

	public Collection getValoraciones() {
		return valoraciones;
	}
	
	
	//Otros metodos
	
	public void añadirValoracion(Valoracion val){
		valoraciones.add(val);
	}

	
}
