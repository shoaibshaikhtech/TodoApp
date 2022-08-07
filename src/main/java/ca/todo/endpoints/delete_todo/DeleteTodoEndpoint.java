package ca.todo.endpoints.delete_todo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.todo.service.TodoCommandService;

@RestController
public class DeleteTodoEndpoint {
	
	@Autowired
	private TodoCommandService commandService;

	
	@GetMapping("todos/delete/{todoId}")
	public void deleteTodo(@PathVariable String todoId) {
		commandService.deleteTodo(UUID.fromString(todoId));
	}

}
