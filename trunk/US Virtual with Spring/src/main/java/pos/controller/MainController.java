package pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//asi guardo el carrito como sesion
@RequestMapping("/store")
@SessionAttributes("order")
public class MainController {

	@RequestMapping("/productos")
	public String getProductos(Model model){
		//TODO
		return "productos";
	}
	
	@RequestMapping("/carrito")
	public String getCarrito(@RequestParam("pid") String pid, Model model){
		//TODO aqui hay que meter el nuevo elemento
		//que vamos a comprar
		System.out.println("Se pretende comprar el elemento "+pid);
		return "carrito";
	}
	
	@RequestMapping("/confirmar")
	public String getConfirmar(Model model){
		//TODO
		return "confirmar";
	}
	
	@RequestMapping("/pagar")
	public String getPagar(Model model){
		//TODO aqui si que habria que obtener los datos de la cuenta
		//y la direccion para insertarlos
		//insertar solo esto, asi nos ahorramos el n a m de hibernate :-)
		return "pagar";
	}
	
	@RequestMapping(value="/eliminar")
	public String getEliminar(@RequestParam("pid") String pid, Model model){
		//TODO hay que eliminar el producto del carrito
		return "productos";
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String getNuevoProducto(Model model){
		//TODO
		return null;
	}

	
}
