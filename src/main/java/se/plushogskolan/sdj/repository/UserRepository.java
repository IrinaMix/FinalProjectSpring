package se.plushogskolan.sdj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.plushogskolan.sdj.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
<<<<<<< HEAD

=======
	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
>>>>>>> ec76f48415104e27d302512c9438c5019108e790
	
}
