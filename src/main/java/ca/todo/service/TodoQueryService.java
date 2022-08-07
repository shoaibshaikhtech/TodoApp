package ca.todo.service;

import java.util.List;

import ca.todo.domain.TodoTask;

public interface TodoQueryService {
	
	List<TodoTask>	getAllTodos();
}
