package se.plushogskolan.sdj.repository;

import org.springframework.data.repository.CrudRepository;

import se.plushogskolan.sdj.model.Issue;

public interface IssueRepository extends CrudRepository<Issue, Long>{

}
