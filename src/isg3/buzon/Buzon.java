package isg3.buzon;
import java.util.*;

public class Buzon {

	/**
	 * Conjunto de mensajes que hay en el buzon
	 */
	private Collection mensajes;
	
	public Collection getMensajes(){
		return this.mensajes;
	}
	
	public int getNumMensajes(){
		return this.mensajes.size();
	}
	
	public Mensaje getMensaje(long id){
		Mensaje m = null;
		
		//busqueda del mensaje
		
		return m;
	}
	/**
	 * Devuelve los mensajes nuevos en dicho buzón.
	 * 
	 * @return Collection de mensajes nuevos
	 */
	public Collection getMensajesNuevos(){
		List l = new ArrayList();
		
		Iterator it = this.mensajes.iterator();
		
		while (it.hasNext()){
			Mensaje m = (Mensaje)it.next();
			
			if (!m.getLeido()){
				l.add(m);
			}
		}
		
		return l;
	}
	
}
