package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.*;
import se.plushogskolan.sdj.model.WorkItem;
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
	public List<WorkItem> getAllByStatus(String status){
		return this.workItemRepository.findAllByStatus(status);
	}

	@Transactional
	public List<WorkItem> getAllByUser(String userId){
		return this.workItemRepository.findAllByUser(userId);
	}

	@Transactional
	public List<WorkItem> getAllByUser(User user){
		return this.workItemRepository.findAllByUser(user);
	}
	
	@Transactional
	public List<WorkItem> getAllByText(String text) {
//		return this.workItemRepository.findAllByText(text);
		return null;
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

	@Transactional
	public void addWorkItemToUser(WorkItem workItem, User user){
		if( user.getStatus().equals(Status.ACTIVE.toString()) && checkNumberofWorkItems(user)){
			workItem.setUser(user);
			this.workItemRepository.save(workItem);
		}
		else{
			throw new ServiceException("Can not add a user to work item.");
		}
	}

	/**
	 * This method checks to see if there are 5 work items or less assigned to a user.
	 * @param user
	 * @return
     */
	public boolean checkNumberofWorkItems(User user){
		if(this.workItemRepository.findAllByUser(user).size()<=5){
			return true;
		}
		else{
			return false;
		}
	}
}
