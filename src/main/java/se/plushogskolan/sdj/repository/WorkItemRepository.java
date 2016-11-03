package se.plushogskolan.sdj.repository;

import org.springframework.data.repository.CrudRepository;

import se.plushogskolan.sdj.model.WorkItem;;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long> {

}
