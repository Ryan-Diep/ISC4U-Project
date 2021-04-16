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
	
	//returns the collection of cart items, returning the entity identified by the given users and textbooks
	public List<CartItem> listCartItems(Users users) {
		return cartRepo.findByUsers(users);
	}
	
	//add product to table
	public Integer addProduct(Integer textbook_id, Integer quantity, Users users) {
		Integer addedQuantity = quantity;
		
		//Get textbook by id
		Textbooks textbooks = textbookRepo.findById(textbook_id).get();
		
		//Add textbooks based on user and textbook
		cartRepo.findByUsersAndTextbooks(users, textbooks);
		
		//Find out if textbook had previously been added to the table
		//If it is not the first time it is being added, update quantity
		if(cartItem != null) {
			addedQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(addedQuantity);
		} 
		//If it is the first time it is being added, create new cartItem object
		else {
			cartItem = new CartItem();
			cartItem.setUsers(users);
			cartItem.setTextbooks(textbooks);
		}
		
		//Save in repository
		cartRepo.save(cartItem);
		
		return addedQuantity;
	}
	
	//remove textbook from table
	public void removeTextbook(Integer textbook_id, Users users) {
		cartRepo.deleteByUsersAndTextbooks(users.getId(), textbook_id);
		textbookRepo.deleteByUsersAndTextbooks(users.getId(), textbook_id);
	}
}
