package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.model.WorkItem;
import se.plushogskolan.sdj.model.WorkItem;
import se.plushogskolan.sdj.model.WorkItemStatus;
import se.plushogskolan.sdj.repository.UserRepository;
import se.plushogskolan.sdj.repository.WorkItemRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkItemService {
	
	private final WorkItemRepository workItemRepository;

	@Autowired
	public WorkItemService(WorkItemRepository workItemRepository) {
		this.workItemRepository = workItemRepository;
	}

	public List<WorkItem> findAllByTeamName(String name){
		return workItemRepository.findAllByTeamName(name);
	}
	
	@Transactional
	public List<WorkItem> findAllByStatus(String status){
		return this.workItemRepository.findAllByStatus(status);
	}

	@Transactional
	public List<WorkItem> findAllByUser(Long userId){
		return this.workItemRepository.findAllByUser(userId);
	}

	@Transactional
	public List<WorkItem> findAllByUser(User user){
		return this.workItemRepository.findAllByUser(user);
	}
	
	public WorkItem create(WorkItem workItem){
		return workItemRepository.save(workItem);
	}
	
	@Transactional
	public boolean updateStatus(Long id, WorkItemStatus status){
		WorkItem workItem=workItemRepository.findOne(id);
		if(workItem==null)
			return false;
		workItem.setStatus(status.toString());
		workItemRepository.save(workItem); 
		return true;
	}

	@Transactional
	public boolean delete(Long id){
		WorkItem workItem=workItemRepository.findOne(id);
		if(workItem==null)
			return false;
		workItemRepository.delete(workItem);
		return true;
	}
	
	public List<WorkItem> findByTitleContaining(String text){
		return workItemRepository.findByTitleContaining(text);
	}
	
	public List<WorkItem> findByDescriptionContaining(String text){
		return workItemRepository.findByDescriptionContaining(text);
	}
}
