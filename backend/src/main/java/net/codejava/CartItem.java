package net.codejava;

import javax.persistence.*;

@Entity
public class CartItem {
	
	//declare variables
	//auto generate a unique id type with each new user
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	
	@ManyToOne
	@JoinColumn(name = "textbook_id")
	private Textbooks textbooks;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users users;
	
	private int quantity;
	
	//getters and setters
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Textbooks getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(Textbooks textbooks) {
		this.textbooks = textbooks;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
