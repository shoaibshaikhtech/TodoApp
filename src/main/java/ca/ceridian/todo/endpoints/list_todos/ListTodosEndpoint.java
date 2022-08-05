package ca.ceridian.todo.endpoints.list_todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ca.ceridian.todo.repository.TodoTaskRepository;

@RestController
public class ListTodosEndpoint {
	
	@Autowired
	private TodoTaskRepository repository;

	 
	 @GetMapping(path = {"/","/todos/list","/list"},produces = MediaType.APPLICATION_JSON_VALUE)
	 public ModelAndView process() {
		 ModelAndView mav = new ModelAndView("list-todos");
		 mav.addObject("todos", repository.findAll());
		 return mav; 
	 }
	

}
