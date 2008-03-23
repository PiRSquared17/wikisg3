package isg3.articulo;
import java.util.*;


public class Wiki {

	private static Wiki w = null;
	
	private Collection categorias;
	
	private Collection articulos;
	
	public Collection getCategorias() {
		return categorias;
	}

	public Collection getArticulos() {
		return articulos;
	}
	
	private void inicializa(){
		categorias = new ArrayList();
		articulos = new ArrayList();

		
		//Creacion de categorias
		Categoria c1 = new Categoria("Ciencias","");
		Categoria c2 = new Categoria("Deportes","");
		Categoria c3 = new Categoria("Cine","");
		
		//Creacion de los articulos
		Articulo a1 = new Articulo("La Fisica","ole", c1);
		Articulo a2 = new Articulo("El Kun","crack", c2);
		Articulo a3 = new Articulo("Jurassic Park","dinosaurio", c3);
		Articulo a4 = new Articulo("Forlan","otro crack", c2);
		Articulo a5 = new Articulo("Jurassic Park2","dinosaurio2", c3);
		
		categorias.add(c1);
		categorias.add(c2);
		categorias.add(c3);
		
		articulos.add(a1);
		articulos.add(a2);
		articulos.add(a3);
		articulos.add(a4);
		articulos.add(a5);
		
	}
	
	private Wiki(){
		this.inicializa();
	}
	
	public static synchronized Wiki getInstance(){
		if (w == null){
			return new Wiki();
		}
		else{
			return Wiki.w;
		}
	}


}
