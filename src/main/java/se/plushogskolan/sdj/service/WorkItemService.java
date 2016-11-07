package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Transactional
	public List<WorkItem> getAllByStatus(String status){
		return this.workItemRepository.findAllByStatus(status);
	}

	@Transactional
	public List<WorkItem> getAllByTeam(String teamId){
		return this.workItemRepository.findAllByTeam(teamId);
	}

	@Transactional
	public List<WorkItem> getAllByUser(String userId){
		return this.workItemRepository.findAllByUser(userId);
	}

	@Transactional
	public List<WorkItem> getAllByText(String text) {
		return this.workItemRepository.findAllByText(text);
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
	
	public List<WorkItem> findByDescriptionContaining(String text){
		return workItemRepository.findByDescriptionContaining(text);
	}
}
