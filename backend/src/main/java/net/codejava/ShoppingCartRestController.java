package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartRestController {
	@Autowired
	private ShoppingCartServices cartService;
	
	@Autowired
	private CustomUserDetailsService userService;
	
	//add textbook information to cart
	@PostMapping("/cart/add/{tid}/{qty}")
	public String addProducttoCart(@PathVariable("pid") Integer textbook_id, 
			@PathVariable("qty") Integer quantity, 
			@AuthenticationPrincipal Authentication authentication) {
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "You must login to add this product to shopping cart.";
		}
		
		Users users = userService.getCurrentlyLoggedInUsers(authentication);
		
		//If user is not authenticated
		if (users == null) {
			return "You must login to add this product to your shopping cart";
		}
		
		//Call the addProduct method
		Integer addedQuantity = cartService.addProduct(textbook_id, quantity, users);
		
		return addedQuantity + "item(s) of this product were added to your shopping cart";
	}
	
	//remove textbook information from cart
	@PostMapping("/cart/remove/{pid}")
	public String removeProductFromCart(@PathVariable("pid") Integer textbook_id,
			@AuthenticationPrincipal Authentication authentication) {
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "You must login to remove product.";
		}
		
		Users users = userService.getCurrentlyLoggedInUsers(authentication);
		
		//If user is not authenticated
		if (users == null) {
			return "You must login to remove product.";
		}
		
		//Call the removeTextbook method
		cartService.removeTextbook(textbook_id, users);
		
		return "The product has been removed from you shopping cart.";
	}
}
