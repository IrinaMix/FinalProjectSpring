package se.plushogskolan.sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.repository.UserRepository;
import se.plushogskolan.sdj.repository.WorkItemRepository;

@Service
public class WorkItemService {
	private final WorkItemRepository workItemRepository;

	@Autowired
	public WorkItemService(WorkItemRepository workItemRepository) {
		this.workItemRepository = workItemRepository;
	}



}
