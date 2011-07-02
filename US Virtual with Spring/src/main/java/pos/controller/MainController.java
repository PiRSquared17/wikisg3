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
		return null;
	}
	
	@RequestMapping("/pagar")
	public String getPagar(Model model){
		//TODO
		return null;
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String getEliminar(Model model){
		//TODO
		return null;
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String getNuevoProducto(Model model){
		//TODO
		return null;
	}

	
}
