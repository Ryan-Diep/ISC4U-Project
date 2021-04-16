package net.codejava;
 
import javax.persistence.*;
 
@Entity
public class Users {
    
	//declare variables
	//auto generate a unique id type with each new user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int USER_ID;

    private String USER_NAME;

    private String FIRST_NAME;

    private String LAST_NAME;

    private String PASSWORD;

    private String EMAIL_ADDRESS;

    //getters and setters
    public int getId() {
      return USER_ID;
    }

    public void setId(Integer USER_ID) {
      this.USER_ID = USER_ID;
    }

    public String getUserName() {
      return USER_NAME;
    }

    public void setUserName(String USER_NAME) {
      this.USER_NAME = USER_NAME;
    }

    public String getFirstName() {
      return FIRST_NAME;
    }

    public void setFirstName(String FIRST_NAME) {
      this.FIRST_NAME = FIRST_NAME;
    }

    public String getLastName() {
      return LAST_NAME;
    }

    public void setLastName(String LAST_NAME) {
      this.LAST_NAME = LAST_NAME;
    }

    public String getPassword() {
      return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
      this.PASSWORD = PASSWORD;
    }

    public String getEmail() {
      return EMAIL_ADDRESS;
    }
    
    public void setEmail(String EMAIL_ADDRESS) {
      this.EMAIL_ADDRESS = EMAIL_ADDRESS;
    }
  }