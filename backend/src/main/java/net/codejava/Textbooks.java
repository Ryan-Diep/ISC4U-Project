package net.codejava;
 
import javax.persistence.*;
 
@Entity
public class Textbooks {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tb_id;

    private String tb_name;

    private String tb_author;

    private float tb_original_price;

    private float tb_current_price;

    private int tb_condition;
    
    private String tb_description;

    private String tb_subject;
    
    private int tb_seller_id;
    
    private int tb_quantity;

    public int getTextbookId() {
      return tb_id;
    }

    public void setTextbookId(int tb_id) {
      this.tb_id = tb_id;
    }

    public String getName() {
      return tb_name;
    }

    public void setName(String tb_name) {
      this.tb_name = tb_name;
    }

    public String getAuthor() {
      return tb_author;
    }

    public void setAuthor(String tb_author) {
      this.tb_author = tb_author;
    }

    public float getOriginalPrice() {
      return tb_original_price;
    }

    public void setOriginalPrice(float tb_original_price) {
      this.tb_original_price = tb_original_price;
    }
    
    public float getCurrentPrice() {
    	return tb_current_price;
    }

    public void setCurrentPrice(float tb_current_price) {
    	this.tb_current_price = tb_current_price;
    }
      
    public int getCondition() {
    	return tb_condition;
    }

    public void setCondition(int tb_condition) {
    	this.tb_condition = tb_condition;
    }
      
    public String getDescription() {
      return tb_description;
    }

    public void setDescription(String tb_description) {
      this.tb_description = tb_description;
    }

    public String getSubject() {
      return tb_subject;
    }
    
    public void setSubject(String tb_subject) {
      this.tb_subject = tb_subject;
    }
    
    public int getSellerId() {
    	return tb_seller_id;
    }
    
    public void setSellerId(int tb_seller_id) {
    	this.tb_seller_id = tb_seller_id;
    }
    public int getQuantity() {
    	return tb_quantity;
    }
    
    public void setQuantity(int tb_quantity) {
    	this.tb_quantity = tb_quantity;
    }
  }