package se.plushogskolan.sdj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import se.plushogskolan.sdj.model.Team;
import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.model.WorkItem;
import se.plushogskolan.sdj.model.WorkItemStatus;
import se.plushogskolan.sdj.repository.TeamRepository;
import se.plushogskolan.sdj.service.TeamService;
import se.plushogskolan.sdj.service.UserService;
import se.plushogskolan.sdj.service.WorkItemService;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.plushogskolan.sdj");
			context.refresh();
			
			WorkItemService workItemService=context.getBean(WorkItemService.class);
			UserService userService = context.getBean(UserService.class);
			TeamService teamService = context.getBean(TeamService.class);
			
			
//			WorkItem w=new WorkItem("myTitle","mydesc");
//			w.setStatus(WorkItemStatus.Unstarted.toString());
//			User u=userService.getUser(2l);
//			w.setUser(u);
//			workItemService.create(w);
//			System.out.println(workItemService.findAllByTeamName("newName06"));
			
			
			//TEST
//			Team team = new Team("newName06");
//			teamService.addTeam(team);
//			User user = new User("iman02", "tahriri", "imta030111100", team);
//			userService.addUser(user);
//			User user = userService.getUser((long) 21);
//			User user = userService.getUserByUsername("imta01");
//			List<User> users = userService.getUserByFirstname("firstname");
//			List<User> users = userService.getUserByLastname("lastname");
//			List<User> users = userService.getAllUsersInTeam(team);
			
//			userService.deactivateUser(user);
//			System.out.println(users.size());
//			teamService.addTeam(team);
//			teamService.deactivateTeam("teamTest");
//			teamService.findAllTeams().forEach(System.out::println);
			
//			Employee employee1 = new Employee("Luke", "Skywalker", "1001", new Address("street1", "postal1", "zip1"));
//			Employee employee2 = new Employee("Leia", "Skywalker", "1001", new Address("street2", "postal2", "zip2"));
//			EmployeeService  service = context.getBean(EmployeeService.class);
//			service.addEmployee(employee1);
//			service.addEmployee(employee2);
			
			// Paging
//			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
//			Page<Employee> result = repository.findAll(new PageRequest(0, 5));
//			result.forEach(System.out::println);
			
		}
	}
}
