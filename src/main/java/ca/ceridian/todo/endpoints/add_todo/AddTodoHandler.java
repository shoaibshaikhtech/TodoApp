package ca.ceridian.todo.endpoints.add_todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ca.ceridian.domain.TodoTask;

@RestController
public class AddTodoHandler {
	
	@GetMapping("/addTodoForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-todo-form");
		TodoTask todo = new TodoTask();
		mav.addObject("todo", todo);
		return mav;
	}

}
