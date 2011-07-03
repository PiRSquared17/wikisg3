package pos.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pos.domain.Address;
import pos.domain.AddressCreditCardForm;
import pos.domain.CreditCard;
import pos.domain.IPOSProcessor;
import pos.domain.Order;
import pos.domain.POSProcessor;
import pos.domain.Product;
import pos.service.POSService;

@Controller
//asi guardo el carrito como sesion
@RequestMapping("/store")
@SessionAttributes("order")
public class MainController {

	@Resource(name="posService")
	private POSService posService;
	
	@RequestMapping("/productos")
	public String getProductos(ModelMap map){
		//XXX aqui creamos la orden al principio de la sesion
		//cuidado, si pasamos otra vez por aqui... que pasa???
		if (!map.containsAttribute("order")){
			Order order = new Order();
			map.addAttribute("order",order);
			List<Product> products = posService.getAllProducts();
			map.addAttribute("products", products);
			System.out.println("La orden se crea correctamente");
		}
		return "productos";
	}

	
	@RequestMapping("/confirmar")
	public String getConfirmar(Model model){
		System.out.println("Por confirmar pasa correctamente");
		model.addAttribute("addressCreditCard", new AddressCreditCardForm());
		return "confirmar";
	}
	

	
	@RequestMapping(value = "/pagar", method = RequestMethod.POST)
	public String getPagar(@ModelAttribute("addressCreditCard") AddressCreditCardForm acc,
			BindingResult br1
			,@ModelAttribute("order") Order order,
			BindingResult br2
			//Model model
			){
		//TODO aqui si que habria que obtener los datos de la cuenta
		//y la direccion para insertarlos
		//insertar solo esto, asi nos ahorramos el n a m de hibernate :-)
		
		System.out.println("Pasando por getPagar con el Address");
		
		//XXX momentaneo antes de usar hibernate
		IPOSProcessor pos = new POSProcessor();
		Address address = acc.getAddress();
		CreditCard ccard = acc.getCreditCard();
		
//		order.setDeliverto(address);
//		order.setPayment(ccard);
//		order.setTimeplaced(new Date());
//		order.setPlacedbyCustomer("practica");
//		pos.placeOrder(order);
//		order.setPlacedbyCustomer((String)session.getAttribute("session.user"));
		
		return "pagar";
	}
	
	@RequestMapping(value="/eliminar")
	public String getEliminar(@RequestParam("pid") Integer pid, Model model){
		//TODO hay que eliminar el producto del carrito
		
		System.out.println("Por eliminar pasa correctamente");
		return "productos";
	}
	
	@RequestMapping("/carrito")
//	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String getNuevoProducto(@ModelAttribute("order") Order order,
			@RequestParam("pid") Integer pid,
			Model model){
		
		//XXX por aqui pasa correctamente
		System.out.println("Vamos a meter al carrito "+pid);
		//TODO dada la orden, obtener desde BD el producto
		//indicado por pid, y meterlo en la orden
		return "carrito";
	}

	
}
