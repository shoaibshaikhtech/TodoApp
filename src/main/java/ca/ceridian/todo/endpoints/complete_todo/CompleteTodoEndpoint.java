package ca.ceridian.todo.endpoints.complete_todo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.ceridian.todo.repository.TodoTaskRepository;
import ca.ceridian.validation.ValidationException;
import ca.ceridian.validation.ValidationType;

@Controller
public class CompleteTodoEndpoint {
	
	@Autowired
	private TodoTaskRepository repository;

	
	@GetMapping("todos/complete")
	public String completeTodo(@RequestParam UUID todoId,RedirectAttributes redirAttrs) {
		var todo = repository.findById(todoId);
		if(todo.isEmpty()) {
			redirAttrs.addFlashAttribute("error", new ValidationException("record_not_found", "TODO not found",ValidationType.INPUT));
			return "redirect:/list";
		}
		todo.get().setCompleted(true);
		repository.save(todo.get());
		return "redirect:/list";
	}

}
