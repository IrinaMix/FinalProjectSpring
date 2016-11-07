package se.plushogskolan.sdj.repository;


import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.model.WorkItem;
import java.util.List;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long> {

    List<WorkItem> findAllByStatus(String status);

    	@Query("select w from WorkItem w where w.user.team.name=:teamName")
    List<WorkItem> findAllByTeamName(@Param("teamName") String teamName);

    List<WorkItem> findAllByUser(String userId);
    List<WorkItem> findAllByUser(User user);

    //I get an error on the first wi, is not expected. Why is this?
//    @Query("select wi from #{#entityName} wi where wi.number like :number")
//    List<WorkItem> findAllByText(@Param("number") String num);

    List<WorkItem> findByDescriptionContaining(String text);

}
