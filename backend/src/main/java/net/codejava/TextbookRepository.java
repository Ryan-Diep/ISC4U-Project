package net.codejava;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface TextbookRepository extends JpaRepository<Textbooks, Integer> {
	
}