

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import isg3.article.Article;
import isg3.article.Category;
import isg3.operations.*;
import isg3.user.User;

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
		String cat = (String)request.getParameter("cat");
		
		WikiOperations op = new WikiOperations();
		Category category = op.getCategory(cat);
		HttpSession session = request.getSession(false);
		String user = (String)session.getAttribute("user");
		User u = op.getUser(user);
		Article a = op.getArticle(idArticle);
		if (a!=null){
			op.editArticle(content, idArticle, user, category);
		}else{
			op.addArticle(u, idArticle, content, category);
		}
	
		
		RequestDispatcher rd = request.getRequestDispatcher("./FrontController?res=A2&id="+idArticle);
		if (rd != null){
			rd.forward(request, response);
		}
		
	}   	  	    
}