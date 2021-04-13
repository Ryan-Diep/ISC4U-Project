package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users users = repo.findByUserName(userName);
		if(users == null) {
			
			throw new UsernameNotFoundException("Users not found");
		}
		return new CustomUserDetails(users);
	}

	public Users getCurrentlyLoggedInUsers(Authentication authentication) {
		if (authentication == null) return null;
		
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
