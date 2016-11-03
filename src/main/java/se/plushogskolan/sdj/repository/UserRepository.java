package se.plushogskolan.sdj.repository;

import org.springframework.data.repository.CrudRepository;

import se.plushogskolan.sdj.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	
}
