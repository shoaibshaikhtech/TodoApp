package ca.todo.service;

import java.util.UUID;

import ca.todo.endpoints.add_todo.AddTodoRequest;

public interface TodoCommandService {
	void createTodo(AddTodoRequest todo);
	void deleteTodo(UUID todoId);
	void complete(UUID todoId);
}
