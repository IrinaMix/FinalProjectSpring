package se.plushogskolan.sdj.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import se.plushogskolan.sdj.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	
//	@Query("select e from #{#entityName} e where e.name = :name")
//	public Team byName(@Param("name") String xyz);
//	
	public Team findByName(String name);

	
	
	
	
}