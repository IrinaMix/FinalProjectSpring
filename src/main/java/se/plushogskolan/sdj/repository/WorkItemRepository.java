package se.plushogskolan.sdj.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.plushogskolan.sdj.model.WorkItem;
import java.util.List;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long> {

    List<WorkItem> findAllByStatus(String status);

    List<WorkItem> findAllByTeam(String team);

    List<WorkItem> findAllByUser(String id);

    //I get an error on the first wi, is not expected. Why is this?
    @Query("select wi from #{#entityName} wi where wi.number like :number")
    List<WorkItem> findAllByText(@Param("number") String num);



}
