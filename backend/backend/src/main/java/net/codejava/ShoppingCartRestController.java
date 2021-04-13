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
	
	@PostMapping("/cart/add/{tid}/{qty}")
	public String addProducttoCart(@PathVariable("pid") Integer productId, 
			@PathVariable("qty") Integer quantity, 
			@AuthenticationPrincipal Authentication authentication) {
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "You must login to add this product to shopping cart.";
		}
		
		Users users = userService.getCurrentlyLoggedInUsers(authentication);
		
		if (users == null) {
			return "You must login to add this product to your shopping cart";
		}
		
		Integer addedQuantity = cartService.addTextbooks(textbook_id, quantity, users);
		
		return addedQuantity + "item(s) of this product were added to your shopping cart";
	}
}
