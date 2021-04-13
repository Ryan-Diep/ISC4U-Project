package net.codejava;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private Users users;
	
	public CustomUserDetails(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getUserName() {
		return users.getUserName();
	}
	
	public String getFullName() {
		return users.getFirstName() + " " + users.getLastName();
	}
	
	public String getEmail() {
		return users.getEmail();
	}
	public Integer getId() {
		return users.getId();
	}
	
}