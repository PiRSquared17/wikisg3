package isg3.pruebasDAO;

import java.util.*;

import isg3.article.Rate;
import isg3.data.*;
import isg3.user.User;
import isg3.user.UserProfile;

public class PruebasRate {

	
	public void insertRate(){
		UserProfile up = new UserProfile("juanito","juanito@us.es");
		User u = new User("juanito","juanito",up);
		
		Rate r = new Rate(3,"no me gusta",u);
		IRateDAO r_dao = new JDBCRateDAO();
		boolean b = r_dao.insert(r, "El padrino");
		System.out.println("¿Insercion de valoracion positiva?: "+b);
	}
	
	public void selectRate(){
		IRateDAO r_dao = new JDBCRateDAO();
		Rate r = r_dao.select("El padrino", "juanito");
		User u = r.getUser();
		
		System.out.println("El usuario "+u.getNick()+" opina sobre El padrino: " +
				r.getReason());
	}
	
	public void selectAllRates(){
		IRateDAO r_dao = new JDBCRateDAO();
		Collection c = r_dao.selectAll("El padrino");
		Iterator it = c.iterator();
		
		while(it.hasNext()){
			Rate r = (Rate)it.next();
			User u = r.getUser();
			System.out.println("El usuario "+u.getNick()+" opina sobre El padrino: " +
					r.getReason());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebasRate pruebas = new PruebasRate();
		//pruebas.insertRate();
		//pruebas.selectRate();
		pruebas.selectAllRates();

	}

}
