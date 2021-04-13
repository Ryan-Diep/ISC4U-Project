package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.codejava.*;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	public List<CartItem> findByUsers(Users users);
	
	public CartItem findByUsersAndTextbooks(Users users, Textbooks textbooks);
	
}
