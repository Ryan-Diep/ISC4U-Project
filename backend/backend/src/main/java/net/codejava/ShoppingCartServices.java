package net.codejava;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.*;

@Service
@Transactional
public class ShoppingCartServices {
	
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TextbookRepository textbookRepo;
	
	@Autowired
	private CartItem cartItem;
	
	public List<CartItem> listCartItems(Users users) {
		return cartRepo.findByUsers(users);
	}
	
	public Integer addProduct(Integer textbook_id, Integer quantity, Users users) {
		Integer addedQuantity = quantity;
		
		Textbooks textbooks = textbookRepo.findById(textbook_id).get();
		
		cartRepo.findByUsersAndTextbooks(users, textbooks);
		
		if(cartItem != null) {
			addedQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(addedQuantity);
		} else {
			cartItem = new CartItem();
			cartItem.setUsers(users);
			cartItem.setTextbooks(textbooks);
		}
		
		cartRepo.save(cartItem);
		
		return addedQuantity;
	}
}
