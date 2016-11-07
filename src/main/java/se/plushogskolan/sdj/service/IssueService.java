package se.plushogskolan.sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.plushogskolan.sdj.model.WorkItem;
import se.plushogskolan.sdj.model.WorkItemStatus;
import se.plushogskolan.sdj.model.Issue;
import se.plushogskolan.sdj.repository.IssueRepository;
import se.plushogskolan.sdj.repository.WorkItemRepository;

@Service
public class IssueService {


	private IssueRepository issueRepository;
	private WorkItemRepository workItemRepository;

	@Autowired
	public IssueService(IssueRepository issueRepository,WorkItemRepository workItemRepository) {
		this.issueRepository = issueRepository;
		this.workItemRepository = workItemRepository;
	}
	
	public Issue createIssue(Issue issue){
		try{
			Issue newIssue = issueRepository.save(issue);
			return newIssue;
		}catch(Exception e){
			throw new ServiceException("Create issue "+issue.getDescription()+" failed", e);
		}
		
	}
	 
	public void assignToWorkItem(Issue issue, WorkItem workItem) {

		try {
			
			if (workItem.getStatus().equals("Done")) {
			    workItem.setIssue(issue);
				workItem.setStatus(WorkItemStatus.Unstarted.toString());
				workItemRepository.save(workItem);
			} else {
				throw new ServiceException("Assign issue to work item failed. Status of work item is not 'Done'");
			}
		} catch (Exception e) {
			throw new ServiceException("Could not assign issue to work item", e);
		}

	}
   
	public Issue updateIssue(Issue issue, String new_description) {
		try {
			Issue findIssue = issueRepository.findByDescription(new_description);
		    if (!issueRepository.exists(issue.getId())){
		    	throw new ServiceException("Could not update issue.Issue:"+issue.getDescription()+" doesn't exist.");
		    }
			if (findIssue==null){
		    	issue.setDescription(new_description);
		    	issueRepository.save(issue);
		    	return issue;
		    }else
		    	 throw new ServiceException("Issue with name:"+new_description+" already exists.");
		} catch (Exception e) {
			throw new ServiceException("Could not update issue with id:" + issue.getId(), e);
		}
	}

	public List<WorkItem> getAllItemsWithIssue(Issue issue) {
		try {
			return issueRepository.findAllByIssue(issue);
		} catch (Exception e) {
			throw new ServiceException("Could not get all items with issue:"+issue.getDescription(), e);
		}
	}

	public Issue getIssueByName(String name) {
		try {
			return issueRepository.findByDescription(name);
		} catch (Exception e) {
			throw new ServiceException("Could not get issue with name:" + name, e);
		}
	}

}
