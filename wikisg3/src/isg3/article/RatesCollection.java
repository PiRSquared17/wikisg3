package isg3.article;

import java.util.Collection;

public class RatesCollection {

	private float averageRate;
	
	Collection rates;

	public float getAverageRate() {
		return averageRate;
	}

	public Collection getRates() {
		return rates;
	}
	
	/**
	 * Añade una nueva valoración. En caso de que el usuario
	 * emisor de la valoración ya tenga una en el artículo,
	 * no se añadirá.
	 * @param rate la valoración a añadir
	 */
	public void addNewRate(Rate rate){
		//TODO
	}
	
	/**
	 * 
	 * @param rate
	 */
	public void editRate(Rate rate){
		//TODO
	}
	
	/**
	 * Método privado, al que llamamos cada vez que se inserta
	 * una nueva valoración, y se encarga de calcular la nota media
	 * del artículo.
	 */
	private void calculateAverageRate(){
		//TODO
	}
}
