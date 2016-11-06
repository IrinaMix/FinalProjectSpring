package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.model.UserStatus;
import se.plushogskolan.sdj.repository.TeamRepository;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUser(Long Id) {
		return userRepository.findOne(Id);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> getUserByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname);
	}
	
	public List<User> getUserByLastname(String lastname) {
		return userRepository.findByLastname(lastname);
	}
	
	@Transactional
	public User addUser(User user) {
		return	userRepository.save(user);
	}
	
	@Transactional
	public User updateUser(User user) {
		return	userRepository.save(user);
	}
	
	@Transactional
	public User deactivateUser(User user) {
		user.setStatus(UserStatus.INACTIVE);
		return	userRepository.save(user);
	}
	
	@Transactional
	public User activateUser(User user) {
		user.setStatus(UserStatus.ACTIVE);
		return	userRepository.save(user);
	}
	
}