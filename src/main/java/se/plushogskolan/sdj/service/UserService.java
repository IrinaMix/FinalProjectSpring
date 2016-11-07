package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.model.Status;
import se.plushogskolan.sdj.repository.TeamRepository;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final TeamRepository teamRepository;

	@Autowired
	public UserService(UserRepository userRepository, TeamRepository teamRepository) {
		this.userRepository = userRepository;
		this.teamRepository = teamRepository;
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
	
	public List<User> getAllUsersInTeam(Team team) {
		return userRepository.findAllByTeam(team);
	}

	@Transactional
	public User addUser(User user) {
		if (user.getUsername().length() >= 10) {
			teamRepository.save(user.getTeam());
			return userRepository.save(user);
		} else
			throw new ServiceException("Username must be atleast 10 characters long!");
	}

	@Transactional
	public User updateUser(User user) {
		if (user.getUsername().length() >= 10) {
			teamRepository.save(user.getTeam());
			return userRepository.save(user);
		} else
			throw new ServiceException("Username must be atleast 10 characters long!");
	}

	@Transactional
	public User deactivateUser(User user) {
		user.setStatus(Status.INACTIVE);
		return userRepository.save(user);
	}

	@Transactional
	public User activateUser(User user) {
		user.setStatus(Status.ACTIVE);
		return userRepository.save(user);
	}

	// public List<User> getAllUsersInTeam(Team team) {
	// return userRepository.getAllUsersInTeam(team);
	// }

}