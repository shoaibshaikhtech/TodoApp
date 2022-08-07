package ca.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.todo.domain.TodoTask;
import ca.todo.repository.TodoTaskRepository;
import ca.todo.service.TodoQueryService;

@Service
public class TodoQueryServiceImpl implements TodoQueryService{
	
	@Autowired
	private TodoTaskRepository repository;

	@Override
	public List<TodoTask> getAllTodos() {
		return repository.findAll();
	}
	

}
