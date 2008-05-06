package isg3.article;

import isg3.user.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RatesCollection {

	private float averageRate;
	
	private Map rates;

	
	public RatesCollection(){
		
		this.rates = new HashMap();
		this.averageRate = 0;
	}
	
	public float getAverageRate() {
		return averageRate;
	}

	public Collection getRates() {
		return this.rates.values();
	}
	
	public int getNumRates(){
		return this.rates.values().size();
	}
	
	/**
	 * Añade una nueva valoración. En caso de que el usuario
	 * emisor de la valoración ya tenga una en el artículo,
	 * no se añadirá.
	 * @param rate la valoración a añadir
	 * @return b boolean true si se añadió la nueva valoración, 
	 * false en caso contrario
	 */
	public boolean addNewRate(Rate rate){
		//TODO
		boolean b = false;
		User usr = rate.getUser();
		//b = this.rates.containsKey(usr);
		Rate oldRate = (Rate)rates.get(usr);
		if (oldRate == null){//el usuario no tenía valoración previa
			rates.put(usr, rate);
			b = true;
			this.calculateAverageRate(rate.getRate());
		}

		return b;
		
	}
	
	/**
	 * Devuelve la valoración de un usuario, en caso de que la tenga
	 * @param usr el usuario del que desea conocerse la valoración
	 * @return r Rate devuelve la valoración del usuario en caso de 
	 * que ya tuviera, o null en caso contrario
	 */
	public Rate getPreviousRate(User usr){
		
		Rate r = (Rate)this.rates.get(usr);
		return r;
		
	}
	
	/**
	 * 
	 * @param rate
	 */
	public void editRate(Rate rate){
		//TODO
		User usr = rate.getUser();
		
		Rate r = (Rate)this.rates.get(usr);
		if (r!=null){
			//si ya habia una valoracion anterior
			this.rates.remove(usr);
			//la eliminamos, y ponemos la nueva
			this.addNewRate(rate);
		}
	}
	
	/**
	 * Método privado, al que llamamos cada vez que se inserta
	 * una nueva valoración, y se encarga de calcular la nota media
	 * del artículo.
	 */
	private void calculateAverageRate(int lastRate){
		//TODO
		int numVal = this.getNumRates();
		
		if (numVal == 0){
			this.averageRate = lastRate;
		}
		else{
			this.averageRate = ((this.averageRate * numVal) + lastRate)/(numVal + 1);
		}
		
	}
}
