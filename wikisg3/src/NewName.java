

import isg3.operations.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: NewName
 *
 */
 public class NewName extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public NewName() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.processRequest(request, response);
		
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.processRequest(request, response);
	}   	  	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String artName = request.getParameter("id");
		IWikiOperations op = new WikiOperations();
		RequestDispatcher d = null;
		
		if (op.existsArticle(artName)){
			//si el articulo ya existe
			//debemos preguntarle si quiere editarlo
			d = request.getRequestDispatcher("./FrontController?res=A7e");
		}
		else{
			//si no, a crear el articulo desde 0
			d = request.getRequestDispatcher("./FrontController?res=A4e");
		}
		
		if(d!=null){
			d.forward(request,response);
		}
	}
}