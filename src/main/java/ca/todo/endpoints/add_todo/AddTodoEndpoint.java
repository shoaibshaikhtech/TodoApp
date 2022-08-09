package ca.todo.endpoints.add_todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.todo.service.TodoCommandService;

@RestController
public class AddTodoEndpoint {
	
	@Autowired
	private TodoCommandService commandService;

	
	@PostMapping(path = "todos/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addTodoTask(@RequestBody AddTodoRequest todo) {
		commandService.createTodo(todo);
	}
}
