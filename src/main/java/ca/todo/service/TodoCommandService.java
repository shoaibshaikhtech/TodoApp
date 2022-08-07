package ca.todo.service;

import java.util.UUID;

import ca.todo.domain.TodoTask;

public interface TodoCommandService {
	void createTodo(TodoTask todo);
	void deleteTodo(UUID todoId);
	void complete(UUID todoId);
}
