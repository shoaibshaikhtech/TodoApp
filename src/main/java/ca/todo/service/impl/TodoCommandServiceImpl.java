package ca.todo.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.todo.domain.TodoTask;
import ca.todo.repository.TodoTaskRepository;
import ca.todo.service.TodoCommandService;
import ca.todo.validation.ValidationException;
import ca.todo.validation.ValidationType;

@Service
public class TodoCommandServiceImpl implements TodoCommandService{
	
	@Autowired
	private TodoTaskRepository repository;

	@Override
	public void createTodo(TodoTask todo) {
		repository.save(todo);
		
	}

	@Override
	public void deleteTodo(UUID todoId) {
		var todo = repository.findById(todoId);
		if(todo.isEmpty()) {
			throw new ValidationException("record_not_found", "TODO not found",ValidationType.INPUT);
		}
		repository.deleteById(todoId);		
	}

	@Override
	public void complete(UUID todoId) {
		var todo = repository.findById(todoId);
		if(todo.isEmpty()) {
			throw new ValidationException("record_not_found", "TODO not found",ValidationType.INPUT);
		}
		todo.get().setCompleted(true);
		repository.save(todo.get());
		
	}

}
