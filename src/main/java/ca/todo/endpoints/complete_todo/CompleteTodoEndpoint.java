package ca.todo.endpoints.complete_todo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.todo.service.TodoCommandService;

@RestController
public class CompleteTodoEndpoint {
	
	@Autowired
	private TodoCommandService commandService;

	
	@GetMapping("todos/complete/{todoId}")
	public void completeTodo(@PathVariable String todoId) {
		commandService.complete(UUID.fromString(todoId));
	}

}
