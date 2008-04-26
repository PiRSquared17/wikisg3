package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import isg3.articulo.*;

/**
 * Servlet implementation class for Servlet: Prueba
 *
 */
 public class Prueba extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Prueba() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Wiki wik = Wiki.getInstance();
		
		Collection col = wik.getCategorias();
		
		Iterator it1 = col.iterator();
				
		while (it1.hasNext()){
			Categoria c = (Categoria)it1.next();
			System.out.print(c.getNombre()+"\n");
			Iterator it2 = c.getArticulos().iterator();
			while (it2.hasNext()){
				Articulo a = (Articulo)it2.next();
				out.print(a.getTitulo()+"\n");
			}
		}
		
		

		
	}   	  	    
}