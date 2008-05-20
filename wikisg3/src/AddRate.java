

import isg3.article.Article;
import isg3.article.Rate;
import isg3.operations.IWikiOperations;
import isg3.operations.WikiOperations;
import isg3.user.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: AddRate
 *
 */
 public class AddRate extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddRate() {
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
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String title = request.getParameter("title");
		String reason = request.getParameter("reason");
		int rate = Integer.parseInt(request.getParameter("rate"));
		
		IWikiOperations op = new WikiOperations();
		op.addRate(user, reason, rate, title);
		
		RequestDispatcher rd = request.getRequestDispatcher("./FrontController?res=A2&id="+title);
		if (rd != null){
			rd.forward(request,response);
		}
	}
}