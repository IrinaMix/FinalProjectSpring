package se.plushogskolan.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.WorkItem;
import se.plushogskolan.sdj.model.WorkItemStatus;
import se.plushogskolan.sdj.repository.UserRepository;
import se.plushogskolan.sdj.repository.WorkItemRepository;

@Service
public class WorkItemService {
	
	private final WorkItemRepository workItemRepository;

	@Autowired
	public WorkItemService(WorkItemRepository workItemRepository) {
		this.workItemRepository = workItemRepository;
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
