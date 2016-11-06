package se.plushogskolan.sdj.service;

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
	
	public User getUser(String username) {
		return userRepository.findByUsername(username);
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