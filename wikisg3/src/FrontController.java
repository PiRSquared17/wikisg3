

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.TreeMap;
import java.util.Map;

/**
 * Servlet implementation class for Servlet: FrontController
 *
 */
 public class FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   
	 private String user;
	 
	 private String pass;
	 
	 private Map resources;
	 
	 static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}   	
	
	public void init(){
		user = "practica";
		pass = "practica";
		
		resources = new TreeMap();
		
		resources.put("index", "index.jsp");
		resources.put("A1", "printArticles.jsp");
		resources.put("A2", "article.jsp");
		resources.put("A3e","newArticleName.jsp" );
		resources.put("A4e", "editArticle.jsp");
		resources.put("A5l", "rateArticle.jsp");
		resources.put("A6l", "editRate.jsp");
		resources.put("A7e","continueToEdit.jsp");
		resources.put("A8l", "continueToRate.jsp");
		resources.put("A9l","continueToDiscussion.jsp");
		resources.put("C1", "printCategories.jsp");
		resources.put("C2", "category.jsp");
		resources.put("L1", "login.jsp");
		resources.put("S1", "Login");
		resources.put("S2l", "EditArticle");
		resources.put("S3l", "AddRate");
		resources.put("S4l", "NewName");
		resources.put("S5l", "NewRate");
		resources.put("S6l", "EditProfile");
		resources.put("S7l", "Logout");
		resources.put("S8l", "DeleteMessage");
		resources.put("S9l", "SendMessage");
		resources.put("S10l", "AddMessage");
		resources.put("S11l","AddArticleDiscussion");
		resources.put("P1l", "profile.jsp");
		resources.put("P2l", "editProfile.jsp");
		resources.put("B1s", "search.jsp");
		resources.put("M1l", "mailBox.jsp");
		resources.put("M2l", "readMessage.jsp");
		resources.put("M3l", "newMessage.jsp");
		
		
		
		/*resources.put("1", "article.jsp");
		resources.put("2", "category.jsp");
		resources.put("3", "editProfile.jsp");
		resources.put("4", "index.jsp");*/
		
		//Con esto resolvemos el tema de la ofuscacion.
	}
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			processRequest(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
		
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(true);
		String id = (String)request.getParameter("id");
		String resource = (String)request.getParameter("res");
		if (loginRequire(resource)){
			if (login(request)){
				
				if(isEditPage(resource)){
					//Quiere acceder a una pagina de edicion
					HttpSession s = request.getSession(false);
					Long lastEdit = (Long)s.getAttribute("session.lastEdit");
					if (lastEdit == null){
						//No ha realizado ninguna busqueda
						lastEdit = new Long(System.currentTimeMillis());
						RequestDispatcher d = request.getRequestDispatcher((String)resources.get(resource));
						s.setAttribute("session.lastEdit", lastEdit);
						if(d!=null){
							d.forward(request,response);
						}
						
					}else{
						//Ya ha realizado alguna busqueda
						Long currentEdit = System.currentTimeMillis();
						if ((currentEdit - lastEdit) > 15000){
							//Han pasado mas de 15 segundos
							RequestDispatcher d = request.getRequestDispatcher((String)resources.get(resource));
							s.setAttribute("session.lastEdit", currentEdit);
							if(d!=null){
								d.forward(request,response);
							}
							
						}else{
							//No han pasado mas de 15 segundo)
							RequestDispatcher d = request.getRequestDispatcher("error.jsp?type=edit");
							if(d!=null){
								d.forward(request,response);
							}
						}
					}
				}//fin edit
				else{
					RequestDispatcher d = request.getRequestDispatcher((String)resources.get(resource));
					if(d!=null){
						d.forward(request,response);
					}
				}//fin sino search o edit
			}//fin login
			else{
				RequestDispatcher d = request.getRequestDispatcher((String)resources.get("L1"));
				if(d!=null){
					d.forward(request,response);
				}
			}//fin sino login
		}//fin login required
		else{
			RequestDispatcher d = null;
			//Si quiere acceder a una pagina que requiere que este registrado
			if (isSearchPage(resource)){
				//Quiere acceder a una pagina de busqueda
				HttpSession s = request.getSession(false);
				Long lastSearch = null;
				if (s!=null){
					lastSearch = (Long)s.getAttribute("session.lastSearch");
				}
				if (lastSearch == null){
					//No ha realizado ninguna busqueda
					lastSearch = new Long(System.currentTimeMillis());
					d = request.getRequestDispatcher((String)resources.get(resource));
					
					s.setAttribute("session.lastSearch", lastSearch);
				}else{
					//Ya ha realizado alguna busqueda
					Long currentSearch = System.currentTimeMillis();
					if ((currentSearch-lastSearch) > 15000){
						//Han pasado mas de 15 segundos
						d = request.getRequestDispatcher((String)resources.get(resource));

						s.setAttribute("session.lastSearch", currentSearch);
					}else{
						//No han pasado mas de 30 segundos
						d = request.getRequestDispatcher("error.jsp?type=search");

					}
				}//fin search
			}else{
				d = request.getRequestDispatcher((String)resources.get(resource));
			}
			if(d!=null){
				d.forward(request,response);
			}
		}
		
		
	}
	
	/**
	 * copy & paste de us virtual
	 * revisarlo en un futuro
	 * @param request
	 * @return
	 */
	private boolean login(HttpServletRequest request){
		boolean logado = false;

		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user")!=null){
			logado=true;
		}
		
		return logado;
	}
	
	/**
	 * Este metodo recibe un parametro y decide si es necesario estar
	 * logeado para entrar en la pagina.
	 * @param s
	 * @return
	 */
	private boolean loginRequire(String s){
		boolean b = false;
		//un recurso que termine en l implica que es necesario
		//estar logado para acceder a el.
		//un recurso que termine en s significa que es una página
		//de busqueda, para las cuales tambien es necesario estar
		//logado.
		//un recurso que termine en e implica que es una pagina
		//para editar articulos.
		if (s.endsWith("l") || s.endsWith("e")){
			b=true;
		}
		return b;
	}
	
	/**
	 * Metodo que determina si la pagina a la que queremos entrar
	 * es una pagina de busqueda.
	 * @param s
	 * @return
	 */
	private boolean isSearchPage(String s){
		boolean b = false;
		if (s.endsWith("s")){
			b = true;
		}
		return b;
	}
	
	private boolean isEditPage(String s){
		boolean b = false;
		if (s.endsWith("e")){
			b = true;
		}
		return b;
	}
	
	/**
	 * copy & paste de us virtual
	 * revisarlo en un futuro
	 * @param userForm
	 * @param passwdForm
	 * @return
	 */
	public boolean valido(String userForm, String passwdForm) {
		boolean res = false;
		res = (userForm.equals(this.user) && passwdForm.equals(this.pass));
		return res;

	}
	
}