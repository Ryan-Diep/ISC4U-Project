package net.codejava;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
 
public interface TextbookRepository extends JpaRepository<Textbooks, Integer> {
	
	@Query("DELETE FROM CartItem c Where c.users.id = ?! AND c.textbooks.id = ?2")
	@Modifying
	public void deleteByUsersAndTextbooks(int id, Integer textbook_id);
}