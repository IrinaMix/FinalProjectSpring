package se.plushogskolan.sdj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class WorkItem {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private String status;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Issue issue;
	
	protected WorkItem() {}
	
	public WorkItem(String title, String description, String status, User user, Issue issue) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.user = user;
		this.issue = issue;
	}

	public WorkItem(String title, String description) {
		this.title = title;
		this.description = description;
		this.status = WorkItemStatus.Unstarted.toString();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public Issue getIssue() {
		return issue;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}