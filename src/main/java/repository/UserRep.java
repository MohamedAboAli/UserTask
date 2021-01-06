package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.User;



@Repository
public interface UserRep extends JpaRepository<User, Long> {

	 public User findByName(String userName);
	
}
