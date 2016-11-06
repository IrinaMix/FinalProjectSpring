package se.plushogskolan.sdj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.plushogskolan.sdj.model.WorkItem;;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long> {

	List<WorkItem> findByDescriptionContaining(String text);
	
}
