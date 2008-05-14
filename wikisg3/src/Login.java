

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if (user.equals(usuario) && pass.equals(password)){
			req.getSession(true);
			RequestDispatcher d = req.getRequestDispatcher("./FrontController?res="+resource);
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