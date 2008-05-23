package isg3.pruebasDAO;

import isg3.user.*;
import isg3.data.*;

public class PruebasUser {

	public void insertUser(){
		UserProfile up = new UserProfile("juanito","juanito@us.es");
		User u = new User("juanito","juanito",up);
		
		IUserDAO u_dao = new JDBCUserDAO();
		boolean b = u_dao.insert(u);
		
		System.out.println("¿Insercion de usuario positiva?: "+b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebasUser pruebas = new PruebasUser();
		pruebas.insertUser();

	}

}
