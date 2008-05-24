

import isg3.operations.IWikiOperations;
import isg3.operations.WikiOperations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: NewRate
 *
 */
 public class NewRate extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public NewRate() {
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
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artName = request.getParameter("id");
		String user = (String)request.getSession(false).getAttribute("user");
		IWikiOperations op = new WikiOperations();
		RequestDispatcher d = null;
		
		if (op.existsRate(user, artName)){
			//ya tenia una valoracion previa sobre el articulo
			d = request.getRequestDispatcher("./FrontController?res=A8l&id="+artName);
		}
		else{
			//no tenia ninguna valoracion previa sobre el articulo
			d = request.getRequestDispatcher("./FrontController?res=A6l&id="+artName);
		}
		
		if(d!=null){
			d.forward(request,response);
		}
	}
}