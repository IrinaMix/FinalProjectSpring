package se.plushogskolan.sdj.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.repository.TeamRepository;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User addUser(User user) {
//		Team team1 = teamRepository.byName(team.getName());
//		System.out.println(team1);
//		
		return	userRepository.save(user);
		
	}

}
