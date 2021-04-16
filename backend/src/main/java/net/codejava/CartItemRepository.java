package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.codejava.*;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	//declaring list
	public List<CartItem> findByUsers(Users users);
	
	//declaring method
	public CartItem findByUsersAndTextbooks(Users users, Textbooks textbooks);
	
	//find and modify table to delete rows
	@Query("DELETE FROM CartItem c Where c.users.id = ?! AND c.textbooks.id = ?2")
	@Modifying
	public void deleteByUsersAndTextbooks(int id, Integer textbook_id);
	
}
