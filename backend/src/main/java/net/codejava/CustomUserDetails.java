package net.codejava;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	//Declaring variables
	private Users users;
	
	//Declaring constructors
	public CustomUserDetails(Users users) {
		this.users = users;
	}
	
	//Returns the authorities granted to the user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	//Returns password
	@Override
	public String getPassword() {
		return users.getPassword();
	}

	//Returns username
	@Override
	public String getUsername() {
		return users.getUserName();
	}

	//Indicates whether the user's account has expired
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//Indicates whether the user is locked or unlocked
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//Indicates whether the user's credentials have expired	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//Indicates whether the user is enabled or disabled
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//Returns full name
	public String getFullName() {
		return users.getFirstName() + " " + users.getLastName();
	}
	
	//Returns email
	public String getEmail() {
		return users.getEmail();
	}
	
	//Returns id
	public Integer getId() {
		return users.getId();
	}
	
}
