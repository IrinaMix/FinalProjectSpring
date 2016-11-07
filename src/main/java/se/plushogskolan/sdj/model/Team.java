package se.plushogskolan.sdj.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	private String status;
	
	
	protected Team() {
	}

	public Team(String name) {
		this.name = name;
		this.status = Status.ACTIVE.toString();
	}

	public Team(String name, String status) {
		this.name = name;
		this.status = Status.ACTIVE.toString();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
