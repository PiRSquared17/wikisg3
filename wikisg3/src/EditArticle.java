

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import isg3.operations.*;

/**
 * Servlet implementation class for Servlet: EditArticle
 *
 */
 public class EditArticle extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditArticle() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content = (String)request.getParameter("content");
		String idArticle = (String)request.getParameter("id");
		
		WikiOperations op = new WikiOperations();
		op.editArticle(content, idArticle);
		
		RequestDispatcher rd = request.getRequestDispatcher("./FrontController?res=A2&id="+idArticle);
		if (rd != null){
			rd.forward(request, response);
		}
		
	}   	  	    
}