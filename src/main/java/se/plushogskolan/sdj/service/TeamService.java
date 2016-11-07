package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.service.ServiceException;
import se.plushogskolan.sdj.model.Status;
import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.repository.TeamRepository;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class TeamService {

	private TeamRepository teamRepository;
	private UserRepository userRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Transactional
	public Team addTeam(Team team) {
		try {
			if (!teamRepository.exists(team.getId())) {
				return teamRepository.save(team);

			} else {
				throw new ServiceException("Team with this teamname already exists");
			}

		} catch (Exception e) {
			throw new ServiceException("Could not add team: " + team.getName(), e);
		}
	}

	public Iterable<Team> findAllTeams() {
		try {
			return teamRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException("Could not get all teams ", e);
		}
	}

	@Transactional
	public void uppdateTeam(String oldName, String newName) {
		try {

			if (teamRepository.exists(teamRepository.findByName(oldName).getId())) {
				if (!teamRepository.exists(teamRepository.findByName(newName).getId())) {
					Team team = teamRepository.findByName(oldName);
					team.setName(newName);
					teamRepository.save(team);
				} else {
					throw new ServiceException("Team with this teamname " + newName + " exists");

				}
			} else {
				throw new ServiceException("Team with this teamname NOT exists");
			}

		} catch (Exception e) {
			throw new ServiceException("Could not update team", e);
		}
	}

	@Transactional
	public void deactivateTeam(String teamName) {

		try {

			if (teamRepository.exists(teamRepository.findByName(teamName).getId())) {
				Team team = teamRepository.findByName(teamName);
				team.setStatus(Status.INACTIVE.toString());
				teamRepository.save(team);
			} else {
				throw new ServiceException("Team with this teamname NOT exists");
			}

		} catch (Exception e) {
			throw new ServiceException("Could not deactivate team: " + teamName, e);
		}

	}

//	@Transactional
//	public void assigneUserToTeam(String teamName, String userId) {
//		try {
//			if (teamRepository.exists(teamRepository.findByName(teamName).getId())) {
//
//				List<User> users = userRepository.findAllByTeam(teamRepository.findByName(teamName));
//				if (users.size() < 10) {
//					User user1 = userRepository.;
//					team.setStatus(Status.INACTIVE.toString());
//					this.userRepository;
//
//				} else {
//					throw new ServiceException(
//							"This team already has 10 users! (But it is allowed to have MAX 10 users in one team)");
//				}
//
//			} else {
//				throw new ServiceException("Team with this teamId NOT exists");
//			}
//
//		} catch (Exception e) {
//			throw new ServiceException("Could not update team", e);
//		}
//	}

}
