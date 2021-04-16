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
	private ShoppingCartServices cartServices;
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private TextbookRepository repo2;
	
	@Autowired
	private CartItem cartItems;
	
	//show index page
	@GetMapping("")
    public String viewHomePage() {
        return "index";
    }
	
	//show index page
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
    //show user registration page
    @GetMapping("/register")
    //add the attribute named users to all models defined in the controller class
    public String showRegistrationForm(Model model) {
    	model.addAttribute("users", new Users());
    	
    	return "signup_form";
    }
    
    //show sell page
    @GetMapping("/sell")
   //adds the attribute named textnools to all models defined in the controller class
    public String sell(Model model) {
    	model.addAttribute("textbooks", new Textbooks());
    	
    	//Get user authentication value
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	//If user is not authenticated, direct them to the entry page, else allow them to proceed
    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
    		return "entry";
    	}
    	
    	return "sell_form";
    }
    
    //show register success page and proccess register
    @PostMapping("/process_register")
    //encrypt password and save new user
    public String processRegister(Users users) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	String encodedPassword = encoder.encode(users.getPassword());
    	users.setPassword(encodedPassword);
    	repo.save(users);
    	System.out.print(users.getUserName());
    	return "register_success";
    }
    
    //show post success page and process listing
    @PostMapping("/process_post")
    //save new textbook
    public String processPost(Textbooks textbooks) {
    	repo2.save(textbooks);
    	return "post_success";
    }
    
    //show login page
    @GetMapping("/logged_in")
    public String login() {
    	return "logged_in";
    }
    
    //show entry page
    @GetMapping("/entry")
    public String entry() {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
    		return "entry";
    	}
    	
    	return "profile";
    }
    
    //show about us/faq page
    @GetMapping("/about")
    public String about() {
    	return "about";
    }
    
    //show cart page
    @GetMapping("/cart")
    public String cart(Model model, @AuthenticationPrincipal Authentication authentication) {
    	
    	//Pass in the authentication object to see if the user is authenticated
    	Users users = userService.getCurrentlyLoggedInUsers(authentication);
    	List<CartItem> listCartItems = cartServices.listCartItems(users);
    	
    	model.addAttribute("cartItems", cartItems);
    	model.addAttribute("pageTitle", "Shopping Cart");

    	return "cart";
    }
    
    //show browse page
    @GetMapping("/browse")
    public String browse(Model model) {
    	//Add all textbooks within the textbooks table to listTextbooks
        List<Textbooks> listTextbooks = repo2.findAll();
        model.addAttribute("listTextbooks", listTextbooks);
        return "browse";
    }
    
    //show login page
    @GetMapping("/login")
    public String loginPage() {
    	return "login";
    }
   
    

}