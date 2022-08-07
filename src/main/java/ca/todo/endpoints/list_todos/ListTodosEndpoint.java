package ca.todo.endpoints.list_todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.todo.domain.TodoTask;
import ca.todo.service.TodoQueryService;

@RestController
public class ListTodosEndpoint {
	
	@Autowired
	private TodoQueryService queryService;
	
	 
	 @GetMapping(path = {"/","/todos/list","/list"},produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<TodoTask> process() {
		 return queryService.getAllTodos();
	 }
	

}
