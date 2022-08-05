package ca.ceridian.todo.endpoints.add_todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.ceridian.domain.TodoTask;
import ca.ceridian.todo.repository.TodoTaskRepository;

@Controller
public class AddTodoEndpoint {
	
	@Autowired
	private TodoTaskRepository repository;

	
	@PostMapping("todos/add")
	public String addTodoTask(@ModelAttribute TodoTask todo) {
		repository.save(todo);
		return "redirect:/";
	}
}
