package ca.todo.events;

import ca.todo.domain.EventSource;

public interface TodoEventHandler {
	void upsertTodo(EventSource event);
}
