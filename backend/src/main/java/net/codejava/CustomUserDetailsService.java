package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	//Inject bean in UserRepository
	@Autowired
	private UserRepository repo;
	
	/*
	 * Spring Security authenticates user using the Users object based on userName. 
	 * If successful create new CustomUserDetails object to represent the authenticated user
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users users = repo.findByUserName(userName);
		
		//If credentials don't match return exception
		if(users == null) {
			throw new UsernameNotFoundException("Users not found");
		}
		return new CustomUserDetails(users);
	}
	
	//Checks if user is currently logged in
	public Users getCurrentlyLoggedInUsers(Authentication authentication) {
		if (authentication == nDull) return null;
		
		Users users = null;
		Object principal = authentication.getPrincipal();
		
		if (principal instanceof CustomUserDetails) {
			users = ((CustomUserDetails) principal).getUsers();
		} else if (principal instanceof CustomOAuth2User) {
			String userName = ((CustomOAuth2User) principal).getUserName();
			users = getCustomerByUserName(users);
		}
		
		return users;
	}

}
