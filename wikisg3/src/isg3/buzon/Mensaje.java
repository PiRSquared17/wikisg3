package isg3.buzon;

import java.util.*;
import isg3.usuario.*;


public class Mensaje {

	/**
	 * Asunto del mensaje
	 */
	private String asunto;
	
	/**
	 * Cuerpo del mensaje
	 */
	private String cuerpo;
	
	/**
	 * Fecha de envio del mensaje
	 */
	private Date fecha;
	
	/**
	 * Usuario que envia el mensaje
	 */
	private Usuario origen;
	
	/**
	 * Usuario que recibe el mensaje
	 */
	private Usuario destino;
	
	/**
	 * Nos indica si el mensaje ya ha sido leido o no
	 */
	private boolean leido;
	
	/**
	 * Constructor con parámetros de la clase Mensaje
	 * 
	 * @param o usuario origen del mensaje
	 * @param d usuario destino del mensaje
	 * @param asunto asunto del mensaje
	 * @param cuerpo cuerpo del mensaje
	 */
	public Mensaje(Usuario o, Usuario d, String asunto, String cuerpo){
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.origen = o;
		this.destino = d;
		this.leido = false;
		
		//establecemos la fecha actual con el metodo setTime de Date
		this.fecha = new Date();
		this.fecha.setTime(System.currentTimeMillis());
	}

	//gettets & setters
	
	public String getAsunto() {
		return asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public Date getFecha() {
		return fecha;
	}

	public Usuario getOrigen() {
		return origen;
	}

	public Usuario getDestino() {
		return destino;
	}
	
	public boolean getLeido(){
		return this.leido;
	}
	
	public void setLeido(boolean l){
		this.leido = l;
	}
}
