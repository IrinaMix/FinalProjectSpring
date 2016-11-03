package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.service.ServiceException;
import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.repository.TeamRepository;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Transactional
	public Team addTeam(Team team) {
//		Team team1 = teamRepository.byName(team.getName());
//		System.out.println(team1);
//		
		return	teamRepository.save(team);
		
	}

	public Iterable<Team> findAllTeams() {
		return teamRepository.findAll();
	}

	@Transactional
	public void uppdateTeam(String teamName, String newName) {
		Team team = teamRepository.findByName(teamName);
		team.setName(newName);
		teamRepository.save(team);
	}

	@Transactional
	public void deactivateTeam(String teamName) {
		Team team = teamRepository.findByName(teamName);
		team.setStatus("Inactive");
		teamRepository.save(team);
	}

	@Transactional
	public void assigneUserToTeam(String teamName, User user) {
		Team team = teamRepository.findByName(teamName);
		team.setStatus("Inactive");
		teamRepository.save(team);
	}

}
