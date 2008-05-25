

import isg3.operations.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: AddMessage
 *
 */
 public class AddMessage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddMessage() {
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
		IWikiOperations op = new WikiOperations();
		String subject = request.getParameter("subject");
		String to = request.getParameter("to");
		String content = request.getParameter("content");
		String user = (String)request.getSession(false).getAttribute("user");
		
		//HACER ALGUNA COMPROBACION PARA VER QUE LOS CAMPOS
		//NO ESTAN VACIOS
		boolean b = op.sendMessage(user, to, subject, content);
		RequestDispatcher d = null;
		if(b){
			//hemos enviado bien el mensaje
			//volvemos al buzon
			d = request.getRequestDispatcher("./FrontController?res=M1l&error=false");
		}
		else{
			//no hemos enviado bien el mensaje
			d = request.getRequestDispatcher("./FrontController?res=M3l&error=true");
		}
		
		if (d != null){
			d.forward(request, response);
		}
	}
}