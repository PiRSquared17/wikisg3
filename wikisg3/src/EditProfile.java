

import isg3.operations.IWikiOperations;
import isg3.operations.WikiOperations;
import isg3.user.User;
import isg3.user.UserProfile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: EditProfile
 *
 */
 public class EditProfile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditProfile() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
		
		}
		
		private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			IWikiOperations op = new WikiOperations();
			String pass = request.getParameter("password");
			String newPass = request.getParameter("newPassword");
			String passConfirm = request.getParameter("passwordConfirm");
			String eMail = request.getParameter("eMail");
			HttpSession session = request.getSession(false);
			String user = (String)session.getAttribute("user");
			User u = op.getUser(user);
			if (pass.equals(u.getPass())){
				if (!newPass.equals("")){
					if (newPass.equals(passConfirm)){
						User newU = new User(user, newPass, new UserProfile("",eMail));
						op.editProfile(newU);
						RequestDispatcher req = request.getRequestDispatcher("./FrontController?res=P1l&b=true");
						req.forward(request, response);
					}else{
						RequestDispatcher req = request.getRequestDispatcher("./FrontController?res=P2l&b=false");
						req.forward(request, response);
					}
				}else{
					User newU = new User(user, pass, new UserProfile("",eMail));
					op.editProfile(newU);
					RequestDispatcher req = request.getRequestDispatcher("./FrontController?res=P1l&b=true");
					req.forward(request, response);
				}
			}else{
				RequestDispatcher req = request.getRequestDispatcher("./FrontController?res=P2l&b=false");
				req.forward(request, response);
		}
		
		
	}   	  	    
}