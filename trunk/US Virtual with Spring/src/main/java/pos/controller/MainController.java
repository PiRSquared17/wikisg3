package pos.controller;

import java.util.Date;
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
import pos.domain.Detail;
import pos.domain.Order;
import pos.domain.Product;
import pos.login.LoginForm;
import pos.service.POSService;

@Controller
@RequestMapping("/store")
@SessionAttributes("order")
public class MainController {

	@Resource(name="posService")
	private POSService posService;
	
	@RequestMapping("/init")
	public String initLogin(ModelMap map){
		map.addAttribute("loginForm",new LoginForm());
		return "login";
	}
	
	@RequestMapping("/login")
	public String getLogin(@ModelAttribute("loginForm") LoginForm login, 
			BindingResult br, ModelMap map){
		if (login.getPassword().equals("practica") &&
				login.getUserName().equals("practica")){
			return "redirect:/store/productos";
		}
		else{
			map.addAttribute("loginForm",new LoginForm());
			return "login";
		}
	}
	
	@RequestMapping("/productos")
	public String getProductos(ModelMap map){
		if (!map.containsAttribute("order")){
			Order order = new Order();
			map.addAttribute("order",order);
		}
		List<Product> products = posService.getAllProducts();
		map.addAttribute("products", products);
		return "productos";
	}

	
	@RequestMapping("/confirmar")
	public String getConfirmar(Model model){
//		System.out.println("Por confirmar pasa correctamente");
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
		
//		System.out.println("Pasando por getPagar con el Address");
		
		//XXX momentaneo antes de usar hibernate
		Address address = acc.getAddress();
		CreditCard ccard = acc.getCreditCard();
		
		order.setDeliverto(address);
		order.setPayment(ccard);
		order.setTimeplaced(System.nanoTime());
		order.setPlacedbyCustomer("practica");
		
		//XXX guardamos la orden y todos sus elementos
		posService.saveOrder(order);
		
		return "pagar";
	}
	
	@RequestMapping(value="/eliminar")
	public String getEliminar(@ModelAttribute("order") Order order, 
			@RequestParam("pid") Integer pid, Model model){
		order.removeDetail(pid);
		return "carrito";
	}
	
	@RequestMapping("/carrito")
	public String getNuevoProducto(@ModelAttribute("order") Order order,
			@RequestParam("pid") Integer pid,
			Model model){
		
		Product p = posService.getProduct(pid);
		Detail d = new Detail();
		d.setProduct(p);
		d.setQuantity(1);
		d.setNote("");
		order.addDetail(d);
		
		return "carrito";
	}

	
}
