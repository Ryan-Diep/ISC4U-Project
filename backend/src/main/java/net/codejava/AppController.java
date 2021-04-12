package net.codejava;
 
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
    
	@Autowired
	private UserRepository repo;
	
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
    public String cart() {
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
    
    @GetMapping("/cart2")
    public String cart2() {
    	return "cart2";
    }
    
    @GetMapping("/cart3")
    public String cart3() {
    	return "cart3";
    }
    
    @GetMapping("/browse2")
    public String browse2() {
    	return "browse2";
    }
    
    @GetMapping("/browse3")
    public String browse3() {
    	return "browse3";
    }
    
    /*@GetMapping("/remove_item")
    public String remove_item(Textbooks textbooks) {
    	System.out.print(textbooks.getQuantity());
    	textbooks.setQuantity(textbooks.getQuantity()-1);
    	repo2.save(textbooks);
    	return "post_success";
    }*/

}