

import isg3.operations.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: Login
 *
 */
 public class Login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   
   private String usuario = "practica";
   private String password = "practica";
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request,response);
	}   	  	  
	
	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String user = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		String resource = req.getParameter("oldres");
		String id = req.getParameter("id");
		
		IWikiOperations op = new WikiOperations();
		
		if (op.login(user, pass)){
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			RequestDispatcher d;
			if (id.equals("null")){
				if (resource.equals("null")){
					d = req.getRequestDispatcher("./FrontController?res=index");
				}
				else{
					d = req.getRequestDispatcher("./FrontController?res="+resource);
				}
				
			}else{
				d = req.getRequestDispatcher("./FrontController?id="+id+"&res="+resource);
			}
			
			if(d!=null){
				d.forward(req,res);
			}
		}else{
			RequestDispatcher d = req.getRequestDispatcher("./FrontController?res=L1&b=false&oldres="+resource);
			if(d!=null){
				d.forward(req,res);
			}
		}
	}
}