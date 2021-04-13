package net.codejava;
 
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import net.codejava.*;
 
@Controller
public class AppController {
    
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ShoppingCartServices cartService;
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private TextbookRepository repo2;
	
	@GetMapping("")
    public String viewHomePage() {
        return "index";
    }
	
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    	model.addAttribute("users", new Users());
    	
    	return "signup_form";
    }
    
    @GetMapping("/sell")
    public String sell(Model model) {
    	model.addAttribute("textbooks", new Textbooks());
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
    		return "entry";
    	}
    	
    	return "sell_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(Users users) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	String encodedPassword = encoder.encode(users.getPassword());
    	users.setPassword(encodedPassword);
    	repo.save(users);
    	System.out.print(users.getUserName());
    	return "register_success";
    }
    
    @PostMapping("/process_post")
    public String processPost(Textbooks textbooks) {
    	repo2.save(textbooks);
    	return "post_success";
    }
    
    @GetMapping("/logged_in")
    public String login() {
    	return "logged_in";
    }
    
    @GetMapping("/entry")
    public String entry() {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
    		return "entry";
    	}
    	
    	return "profile";
    }
    
    @GetMapping("/about")
    public String about() {
    	return "about";
    }
    
    @GetMapping("/cart")
    public String cart(Model model, @AuthenticationPrincipal Authentication authentication) {
    	
    	List<CartItem> listCartItems = userService.listcartItems(users);
    	
    	model.addAttribute("cartItems", cartItems);
    	model.addAttribute("pageTitle", "Shopping Cart");
    	
    	
    	
    	return "cart";
    }
    
    @GetMapping("/browse")
    public String browse(Model model) {
        List<Textbooks> listTextbooks = repo2.findAll();
        model.addAttribute("listTextbooks", listTextbooks);
        return "browse";
    }
    
    @GetMapping("/login")
    public String loginPage() {
    	return "login";
    }
   
    

}