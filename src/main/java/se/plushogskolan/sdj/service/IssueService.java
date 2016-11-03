package se.plushogskolan.sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.repository.IssueRepository;
import se.plushogskolan.sdj.repository.UserRepository;

@Service
public class IssueService {


	private final IssueRepository issueRepository;

	@Autowired
	public IssueService(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}

}
